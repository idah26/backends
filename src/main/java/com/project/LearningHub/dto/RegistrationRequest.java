package com.project.LearningHub.dto;

import lombok.Data;

@Data
public class RegistrationRequest {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String fullName;
    private int phoneNumber;
    private String address;
}
