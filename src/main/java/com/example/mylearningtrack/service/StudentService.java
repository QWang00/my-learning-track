package com.example.mylearningtrack.service;

import java.util.List;
import java.util.Map;

public interface StudentService {
    List<Object[]> getTimeSpentByStudent(Long studentId);

    Map<String,Double> getResultCountByStudent(Long studentId);
}
