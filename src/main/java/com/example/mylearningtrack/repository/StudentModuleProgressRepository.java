package com.example.mylearningtrack.repository;

import com.example.mylearningtrack.model.Student;
import com.example.mylearningtrack.model.StudentModuleProgress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentModuleProgressRepository extends JpaRepository<StudentModuleProgress, Long> {
}
