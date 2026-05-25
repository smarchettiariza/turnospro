package com.turnospro.backend.service;

import com.turnospro.backend.dto.UsuarioDTO;
import com.turnospro.backend.model.Usuario;
import com.turnospro.backend.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repo;

    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }

    public UsuarioDTO guardar(Usuario usuario) {
        Usuario u = repo.save(usuario);

        return new UsuarioDTO(
                u.getId(),
                u.getNombre(),
                u.getEmail(),
                u.getRol());
    }

    public List<Usuario> listar() {
        return repo.findAll();
    }
}
