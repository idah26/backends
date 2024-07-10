package com.project.LearningHub.controller;

import com.project.LearningHub.dto.RegistrationRequest;
import com.project.LearningHub.model.Register;
import com.project.LearningHub.model.Student;
import com.project.LearningHub.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/Register")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping("/register")
    public Map<String, String> register(@RequestBody RegistrationRequest request) {
        Register register = new Register();
        register.setUsername(request.getUsername());
        register.setFirstName(request.getFirstName());
        register.setLastName(request.getLastName());
        register.setEmail(request.getEmail());
        register.setPassword(request.getPassword());

        Student student = new Student();
        student.setFullName(request.getFullName());
        student.setEmail(request.getEmail());
        student.setPhoneNumber(request.getPhoneNumber());
        student.setAddress(request.getAddress());

        String result = registerService.registerUser(register, student);
        Map<String, String> response = new HashMap<>();
        response.put("message", result);
        return response;
    }
}


