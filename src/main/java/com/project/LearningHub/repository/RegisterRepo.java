package com.project.LearningHub.repository;

import com.project.LearningHub.model.Register;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepo extends JpaRepository<Register, Long> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}