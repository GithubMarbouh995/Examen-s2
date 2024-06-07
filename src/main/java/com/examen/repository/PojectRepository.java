package com.examen.repository;

import com.examen.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PojectRepository extends JpaRepository<Project, Long> {
}
