package com.example.mylearningtrack.controller;

import com.example.mylearningtrack.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @GetMapping("students/{studentId}/timeSpent")
    public List<Map<String, Object>> getTimeSpent(@PathVariable Long studentId){
        List<Object[]> timeSpentByStudent = studentService.getTimeSpentByStudent(studentId);
        return timeSpentByStudent.stream()
                .map(record-> Map.of("moduleCode", record[0], "timeSpent", record[1]))
                .collect(Collectors.toList());
    }

    @GetMapping("students/{studentId}/resultsDistribution")
    public Map<String,Double> getResultsDistribution (@PathVariable Long studentId){
        return studentService.getResultCountByStudent(studentId);
    }
}
