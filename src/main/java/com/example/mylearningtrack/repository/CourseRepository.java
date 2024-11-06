package com.example.mylearningtrack.repository;

import com.example.mylearningtrack.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
