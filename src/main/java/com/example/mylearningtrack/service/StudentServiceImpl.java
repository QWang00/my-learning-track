package com.example.mylearningtrack.service;

import com.example.mylearningtrack.repository.StudentModuleProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentModuleProgressRepository progressRepository;

    @Override
    public List<Object[]> getTimeSpentByStudent(Long studentId) {
        return progressRepository.findTimeSpentByStudent(studentId);
    }
}
