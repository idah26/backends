package com.project.LearningHub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.LearningHub.model.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {
}