package com.aluracursos.forohub.repositorio;

import com.aluracursos.forohub.modelo.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {}
