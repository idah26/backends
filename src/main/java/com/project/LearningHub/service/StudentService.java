package com.project.LearningHub.service;

import com.project.LearningHub.model.Student;
import com.project.LearningHub.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    public Student postStudent(Student student){
        return studentRepo.save(student);
    }///

    public List<Student> getAllStudent() {
        return  studentRepo.findAll();
    }
    public Optional<Student> findByStudentId(Integer id){
        return studentRepo.findById(id);
    }
    public Student updateStudent(Student student) {
        Student student1 =studentRepo.findById(student.getId())
                .orElseThrow(() -> new RuntimeException("Student not found"));
        student1.setFullName(student.getFullName());
        student1.setEmail(student.getEmail());
        student1.setPhoneNumber(student.getPhoneNumber());
        return studentRepo.save(student);
    }
    public void deleteStudent(int id){
        studentRepo.deleteById(id);
    }
}
