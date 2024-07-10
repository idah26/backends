//package com.project.LearningHub.config;
//
//
//import com.project.LearningHub.repository.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class Security {
//
//    @Autowired
//    private UserRepo userRepo;
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return email -> {
//            com.project.LearningHub.model.User user = userRepo.findByEmail(email);
//            if (user == null) {
//                throw new UsernameNotFoundException("User not found");
//            }
//
//            return org.springframework.security.core.userdetails.User
//                    .withUsername(user.getEmail())
//                    .password(user.getPassword())
//                    .roles() // No roles set
//                    .build();
//        };
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable() // Disable CSRF (not recommended for production)
//                .authorizeRequests()
//                .requestMatchers("/api/user/register").permitAll() // Permit registration endpoint
//                .requestMatchers("/api/user/login").permitAll() // Permit login endpoint
//                .requestMatchers("/api/student/add").permitAll() // Permit booking creation endpoint
//                .requestMatchers("/api/student/get").permitAll() // Permit booking retrieval endpoint
//                .requestMatchers("/api/instructor/cancel/**").permitAll() // Permit booking cancellation endpoint
//                .requestMatchers("/api/instructor/all").permitAll() // Permit booking retrieve endpoint
//                .requestMatchers("/api/student/update").permitAll() // Permit add book endpoint
//                .requestMatchers("/api/student/reset").permitAll() // Permit reset password endpoint
//                .requestMatchers("/admin/**").hasRole("ADMIN") // Restrict admin pages to users with ADMIN role
//                .anyRequest().authenticated() // All other endpoints require authentication
//                .and()
//                .formLogin()
//                .loginPage("/login") // Custom login page URL
//                .permitAll() // Allow access to login page
//                .and()
//                .logout()
//                .permitAll(); // Allow access to logout URL
//        return http.build();
//    }
//
//    @Bean
//    public AuthenticationManager customAuthenticationManager(HttpSecurity http) throws Exception {
//        return http.getSharedObject(AuthenticationManagerBuilder.class)
//                .userDetailsService(userDetailsService())
//                .passwordEncoder(passwordEncoder())
//                .and()
//                .build();
//    }
//}
