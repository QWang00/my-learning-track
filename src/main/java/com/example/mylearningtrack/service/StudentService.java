package com.example.mylearningtrack.service;

import java.util.List;

public interface StudentService {
    List<Object[]> getTimeSpentByStudent(Long studentId);
}
