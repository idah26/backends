package com.project.LearningHub.controller;


import com.project.LearningHub.model.Student;
import com.project.LearningHub.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student/")

public class StudentController {
    @Autowired
    public StudentService studentService;
    @PostMapping("add")
    public ResponseEntity<Student> postStudent(@RequestBody Student student){
        try {
            Student saveStudent =studentService.postStudent(student);
            return ResponseEntity.ok(saveStudent);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
//    public Student postStudent(@RequestBody Student student){
//        return studentService.postStudent(student);
    }
    @GetMapping("all")
    public ResponseEntity<List<Student>>getAllStudents(){
        List<Student> std = studentService.getAllStudent();
        return new ResponseEntity<>(std,HttpStatus.OK);
    }
    @GetMapping("get/{id}")
    public Optional<Student> findById(@PathVariable int id){
        return studentService.findByStudentId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student) {
        student.setId(id);
        Student updatedStudent = studentService.updateStudent(student);
        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }

    @DeleteMapping("ById/{id}")
    public ResponseEntity<?>deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
        return new ResponseEntity<>("Successful deleted",HttpStatus.OK);
    }
}
