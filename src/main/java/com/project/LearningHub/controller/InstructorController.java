package com.project.LearningHub.controller;

import com.project.LearningHub.model.Instructor;
import com.project.LearningHub.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Instructor/")
public class InstructorController {
    @Autowired
    public InstructorService instructorService;
    @PostMapping("add")
    public Instructor postInstructor(@RequestBody Instructor instructor){
        return instructorService.postInstructor(instructor);
    }
    @GetMapping("all")
    public List InstructorList(){
        return instructorService.InstructorList();
    }
    @GetMapping("get/{id}")
    public Optional<Instructor> findById(@PathVariable int id){
        return instructorService.findByInstructorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Instructor> updateinstuctor(@PathVariable int id, @RequestBody Instructor instructor) {
        instructor.setInstructor_id(id);
        Instructor updateInstructor = instructorService.updateInstructor(instructor);
        return new ResponseEntity<>(updateInstructor, HttpStatus.OK);
    }
    @DeleteMapping("ById/{id}")
    public ResponseEntity<?>deleteIsntructor(@PathVariable int instructor_id){
        instructorService.deleteInstructor(instructor_id);
        return new ResponseEntity<>("successful deleted",HttpStatus.OK);
    }

}
