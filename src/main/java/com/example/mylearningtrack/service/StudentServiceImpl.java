package com.example.mylearningtrack.service;

import com.example.mylearningtrack.repository.StudentModuleProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentModuleProgressRepository progressRepository;

    @Override
    public List<Object[]> getTimeSpentByStudent(Long studentId) {
        return progressRepository.findTimeSpentByStudent(studentId);
    }

    @Override
    public Map<String,Double> getResultCountByStudent(Long studentId) {
        List<Object[]> results = progressRepository.findResultCountByStudent(studentId);

        int totalModules = results.stream()
                .mapToInt(result-> ((Long) result[1]).intValue())
                .sum();
        Map<String,Double> percentages = results.stream()
                .collect(Collectors.toMap(
                        result-> (String) result[0],
                        result-> (double) ((Long) result[1] * 100 / totalModules)
                ));

        return percentages;

    }
}
