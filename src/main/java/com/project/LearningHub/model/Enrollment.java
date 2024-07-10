package com.project.LearningHub.model;

import com.project.LearningHub.model.Enum.EnrollmentStatus;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

@ManyToOne
    private Course course;

@ManyToOne
private Student student;

@Enumerated(EnumType.STRING)
private EnrollmentStatus enrollmentStatus;


//    public Enrollment(String student) {
//        this.studentName = student;
//    }
//
//    public String getCourse() {
//        return course;
//    }
//
//    public void setCourse(String course) {
//        this.course = course;
//    }
//
//    public String getStudentName() {
//        return studentName;
//    }
//
//    public void setStudentName(String studentName) {
//        this.studentName = studentName;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//
//
//    }
}
