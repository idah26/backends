package com.project.LearningHub.controller;

import com.project.LearningHub.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3001")
@RequestMapping("/api/Login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("login")
    public Map<String, String> login(@RequestBody Map<String, String> user) {
        String username = user.get("username");
        String password = user.get("password");

        Map<String, String> response = new HashMap<>();
        loginService.authenticate(username, password)
                .ifPresentOrElse(
                        authenticatedUser -> {
                            response.put("message", "Login successful");
                            response.put("token", "fake-jwt-token"); // Simulate token generation
                        },
                        () -> {
                            response.put("message", "Invalid username or password");
                        });

        return response;
    }
}
