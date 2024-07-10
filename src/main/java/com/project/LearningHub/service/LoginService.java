package com.project.LearningHub.service;

import com.project.LearningHub.model.Login;
import com.project.LearningHub.repository.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
public LoginRepo loginRepo;
    public Optional<Login> authenticate(String username, String password) {
        return loginRepo.findByUsername(username)
                .filter(login -> login.getPassword().equals(password));
    }
}
