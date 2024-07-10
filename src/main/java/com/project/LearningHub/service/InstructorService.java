package com.project.LearningHub.service;


import com.project.LearningHub.model.Instructor;
import com.project.LearningHub.repository.InstructorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {
    @Autowired
    private InstructorRepo instructorRepo;

    public Instructor postInstructor(Instructor instructor){
        return instructorRepo.save(instructor);
    }
    public List<Instructor> InstructorList(){
        return instructorRepo.findAll();
    }
    public Optional<Instructor> findByInstructorId(Integer id){
        return instructorRepo.findById(id);
    }
    public Instructor updateInstructor(Instructor instructor) {
        Instructor instructor1 =instructorRepo.findById(instructor.getInstructor_id())
                .orElseThrow(() -> new RuntimeException("instructor not found"));
        instructor1.setInstructorName(instructor.getInstructorName());
        instructor1.setInstructorEmail(instructor.getInstructorEmail());
        instructor1.setInstructorNumber(instructor.getInstructorNumber());

        return instructorRepo.save(instructor);
    }
    public void deleteInstructor(int id){
        instructorRepo.deleteById(id);
    }
}
