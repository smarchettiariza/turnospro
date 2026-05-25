package com.turnospro.backend.controller;

import com.turnospro.backend.model.Turno;
import com.turnospro.backend.model.Usuario;
import com.turnospro.backend.repository.TurnoRepository;
import com.turnospro.backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/turnos")
@CrossOrigin(origins = "http://localhost:3000")
public class TurnoController {

    @Autowired
    private TurnoRepository turnoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    // =========================
    // LISTAR SOLO LOS TURNOS DEL USUARIO LOGUEADO
    // =========================
    @GetMapping
    public List<Turno> listar(Authentication authentication) {
        String username = authentication.getName();
        return turnoRepository.findByUsuario(username);
    }

    // =========================
    // CREAR TURNO
    // =========================
    @PostMapping
    public Turno crearTurno(
            @RequestBody Turno turno,
            Authentication authentication) {

        String username = authentication.getName();

        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() ->
                        new RuntimeException("Usuario no encontrado"));

        // Guardar el username en el campo usuario
        turno.setUsuario(usuario.getUsername());

        return turnoRepository.save(turno);
    }

    // =========================
    // EDITAR TURNO
    // =========================
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarTurno(
            @PathVariable Long id,
            @RequestBody Turno turnoActualizado,
            Authentication authentication) {

        String username = authentication.getName();

        Optional<Turno> optionalTurno =
                turnoRepository.findById(id);

        if (optionalTurno.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Turno turnoExistente = optionalTurno.get();

        // Verificar que el turno pertenezca al usuario logueado
        if (!turnoExistente.getUsuario().equals(username)) {
            return ResponseEntity.status(403)
                    .body("No tenés permiso para modificar este turno");
        }

        turnoExistente.setPaciente(
                turnoActualizado.getPaciente());
        turnoExistente.setMedico(
                turnoActualizado.getMedico());
        turnoExistente.setFecha(
                turnoActualizado.getFecha());

        turnoRepository.save(turnoExistente);

        return ResponseEntity.ok(turnoExistente);
    }

    // =========================
    // ELIMINAR TURNO
    // =========================
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(
            @PathVariable Long id,
            Authentication authentication) {

        String username = authentication.getName();

        Optional<Turno> optionalTurno =
                turnoRepository.findById(id);

        if (optionalTurno.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Turno turno = optionalTurno.get();

        // Verificar que el turno pertenezca al usuario logueado
        if (!turno.getUsuario().equals(username)) {
            return ResponseEntity.status(403)
                    .body("No autorizado");
        }

        turnoRepository.delete(turno);

        return ResponseEntity.ok().build();
    }
}