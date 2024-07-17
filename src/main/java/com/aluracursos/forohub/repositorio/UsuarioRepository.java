package com.aluracursos.forohub.repositorio;

import com.aluracursos.forohub.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {}
