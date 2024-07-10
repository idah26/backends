package com.project.LearningHub.service;

import com.project.LearningHub.model.Register;
import com.project.LearningHub.model.Student;
import com.project.LearningHub.repository.RegisterRepo;
import com.project.LearningHub.repository.StudentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
  @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private RegisterRepo registerRepo;

    public String registerUser(Register register,Student student) {
        if (registerRepo.existsByUsername(register.getUsername())) {
            return "Username already taken";
        }
        if (registerRepo.existsByEmail(register.getEmail())) {
            return "Email already registered";
        }
       Register registerSave = registerRepo.save(register);

       Student createStudent = new Student(); 
        createStudent.setFullName(registerSave.getFirstName()+ " " + registerSave.getLastName());
        createStudent.setRegisterId(registerSave.getId());
        createStudent.setAddress(student.getAddress());
        createStudent.setEmail(registerSave.getEmail());
        createStudent.setPhoneNumber(student.getPhoneNumber());
        Student savedStudent = studentRepo.save(createStudent);

        return "Registration successful";
    }
}