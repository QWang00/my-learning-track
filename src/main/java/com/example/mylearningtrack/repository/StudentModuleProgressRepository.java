package com.example.mylearningtrack.repository;

import com.example.mylearningtrack.model.StudentModuleProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentModuleProgressRepository extends JpaRepository<StudentModuleProgress, Long> {

    @Query("SELECT m.module.code, m.timeSpent FROM StudentModuleProgress m WHERE m.student.id = :studentId")
    List<Object[]> findTimeSpentByStudent(@Param("studentId") Long studentId);

    @Query("SELECT m.result, count(m) FROM StudentModuleProgress m WHERE m.student.id = :studentId Group BY m.result")
    List<Object[]> findResultCountByStudent(@Param("studentId") Long studentId);

}
