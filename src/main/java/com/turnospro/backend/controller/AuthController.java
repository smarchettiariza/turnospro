    package com.turnospro.backend.controller;

    import com.turnospro.backend.model.Usuario;
    import com.turnospro.backend.repository.UsuarioRepository;
    import com.turnospro.backend.security.JwtUtil;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.security.crypto.password.PasswordEncoder;
    import org.springframework.web.bind.annotation.*;

    import java.util.HashMap;
    import java.util.Map;
    import java.util.Optional;

    @RestController
    @RequestMapping("/api/auth")
    @CrossOrigin(origins = "http://localhost:3000")
    public class AuthController {

        @Autowired
        private UsuarioRepository usuarioRepository;

        @Autowired
        private JwtUtil jwtUtil;

        @Autowired
        private PasswordEncoder passwordEncoder;

        // =========================
        // REGISTRO DE USUARIO
        // =========================
        @PostMapping("/register")
        public ResponseEntity<?> register(@RequestBody Usuario usuario) {

            // Verificar si el usuario ya existe
            Optional<Usuario> existente =
                    usuarioRepository.findByUsername(usuario.getUsername());

            if (existente.isPresent()) {
                return ResponseEntity.badRequest()
                        .body("El nombre de usuario ya existe");
            }

            // Encriptar contraseña
            usuario.setPassword(
                    passwordEncoder.encode(usuario.getPassword())
            );

            // Guardar usuario
            Usuario guardado = usuarioRepository.save(usuario);

            // Respuesta
            Map<String, Object> response = new HashMap<>();
            response.put("mensaje", "Usuario registrado correctamente");
            response.put("usuario", guardado);

            return ResponseEntity.ok(response);
        }

        // =========================
        // LOGIN
        // =========================
        @PostMapping("/login")
        public ResponseEntity<?> login(@RequestBody Usuario loginRequest) {

            Optional<Usuario> optionalUsuario =
                    usuarioRepository.findByUsername(loginRequest.getUsername());

            // Usuario no existe
            if (optionalUsuario.isEmpty()) {
                return ResponseEntity.status(401)
                        .body("Usuario o contraseña incorrectos");
            }

            Usuario usuario = optionalUsuario.get();

            // Verificar contraseña
            if (!passwordEncoder.matches(
                    loginRequest.getPassword(),
                    usuario.getPassword())) {

                return ResponseEntity.status(401)
                        .body("Usuario o contraseña incorrectos");
            }

            // Generar token
            String token = jwtUtil.generateToken(usuario.getUsername());

            // Respuesta
            Map<String, Object> response = new HashMap<>();
            response.put("token", token);

            // Datos del usuario para mostrar en el Navbar
            Map<String, Object> usuarioData = new HashMap<>();
            usuarioData.put("id", usuario.getId());
            usuarioData.put("nombre", usuario.getNombre());
            usuarioData.put("username", usuario.getUsername());

            response.put("usuario", usuarioData);

            return ResponseEntity.ok(response);
        }
    }