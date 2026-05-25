package com.turnospro.backend.repository;

import com.turnospro.backend.model.Turno;
import com.turnospro.backend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TurnoRepository extends JpaRepository<Turno, Long> {
    List<Turno> findByUsuario(String username);
}