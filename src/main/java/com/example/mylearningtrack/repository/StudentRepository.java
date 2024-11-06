package com.example.mylearningtrack.repository;

import com.example.mylearningtrack.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
