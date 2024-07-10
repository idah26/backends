package com.project.LearningHub.repository;


import com.project.LearningHub.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepo extends JpaRepository<Login, Long> {
    Optional<Login> findByUsername(String username);
}