package com.project.LearningHub.controller;

import com.project.LearningHub.model.Course;
import com.project.LearningHub.model.Enrollment;
import com.project.LearningHub.model.Student;
import com.project.LearningHub.model.Enum.EnrollmentStatus;
import com.project.LearningHub.repository.CourseRepo;
import com.project.LearningHub.repository.EnrollmentRepo;
import com.project.LearningHub.repository.StudentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enrollment/")
public class EnrollmentController {

    @Autowired
    private EnrollmentRepo enrollmentRepo;

    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private CourseRepo courseRepo;

    @PostMapping("add")
    public ResponseEntity<Enrollment> createEnrollment(@RequestBody Enrollment enrollment) {
        Enrollment savedEnrollment = enrollmentRepo.save(enrollment);
        return new ResponseEntity<>(savedEnrollment, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enrollment> getEnrollmentById(@PathVariable Long id) {
        Enrollment enrollment = enrollmentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Enrollment not found with id: " + id));
        return ResponseEntity.ok(enrollment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Enrollment> updateEnrollment(@PathVariable Long id, @RequestBody Enrollment enrollmentDetails) {
        Enrollment enrollment = enrollmentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Enrollment not found with id: " + id));

        Student student = studentRepo.findById(enrollmentDetails.getStudent().getId())
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + enrollmentDetails.getStudent().getId()));

         Course course = courseRepo.findById(enrollmentDetails.getCourse().getId())
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + enrollmentDetails.getCourse().getId()));


        // enrollment.setCourse(new Course(enrollmentDetails.getCourse()));
        // enrollment.setStudent(new Student(enrollmentDetails.getStudent()));
    
        enrollment.setEnrollmentStatus(EnrollmentStatus.notenrolled);
        Enrollment updatedEnrollment = enrollmentRepo.save(enrollment);
        return ResponseEntity.ok(updatedEnrollment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteEnrollment(@PathVariable Long id) {
        Enrollment enrollment = enrollmentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Enrollment not found with id: " + id));

        enrollmentRepo.delete(enrollment);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}