package com.example.mylearningtrack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GraphController {

    @GetMapping("/student-time-spent")
    public String getTimeSpentPage() {
        return "timeSpent";
    }
}
