//package com.project.LearningHub.service;
//
//
//import com.project.LearningHub.model.User;
//
//import com.project.LearningHub.repository.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class PasswordServices {
//
//    @Autowired
//    private UserRepo userRepo;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    public void resetPassword(String email, String newPassword) {
//        User user = userRepo.findByEmail(email);
//        if (user == null) {
//            throw new RuntimeException("User not found.");
//        }
//
//        // Encode the new password
//        user.setPassword(passwordEncoder.encode(newPassword));
//
//        // Save the updated user with the new password
//        userRepo.save(user);
//    }
//}
//
