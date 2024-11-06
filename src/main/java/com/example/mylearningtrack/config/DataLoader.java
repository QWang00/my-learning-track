package com.example.mylearningtrack.config;

import com.example.mylearningtrack.model.*;
import com.example.mylearningtrack.model.Module;
import com.example.mylearningtrack.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Arrays;
import java.util.List;

@Configuration
public class DataLoader {
    private boolean initialised = false;

    @Bean
    CommandLineRunner loadData(CourseRepository courseRepository,
                               ModuleRepository moduleRepository,
                               StudentRepository studentRepository,
                               StudentModuleProgressRepository progressRepository) {
        return args -> {
            if (!initialised) {
                courseRepository.deleteAll();
                moduleRepository.deleteAll();
                studentRepository.deleteAll();
                progressRepository.deleteAll();
                initialised = true;
            }

            Course course = Course.builder()
                    .code("CS101")
                    .name("Computer Science")
                    .credits(24)
                    .build();
            courseRepository.save(course);

            Module module1 = Module.builder()
                    .code("CS101-1")
                    .name("Introduction to Programming")
                    .credits(3)
                    .course(course)
                    .build();

            Module module2 = Module.builder()
                    .code("CS101-2")
                    .name("Data Structures")
                    .credits(3)
                    .course(course)
                    .build();

            Module module3 = Module.builder()
                    .code("CS101-3")
                    .name("Algorithms")
                    .credits(3)
                    .course(course)
                    .build();

            Module module4 = Module.builder()
                    .code("CS101-4")
                    .name("Database Systems")
                    .credits(3)
                    .course(course)
                    .build();

            Module module5 = Module.builder()
                    .code("CS101-5")
                    .name("Operating Systems")
                    .credits(3)
                    .course(course)
                    .build();

            Module module6 = Module.builder()
                    .code("CS101-6")
                    .name("Computer Networks")
                    .credits(3)
                    .course(course)
                    .build();

            Module module7 = Module.builder()
                    .code("CS101-7")
                    .name("Software Engineering")
                    .credits(3)
                    .course(course)
                    .build();

            Module module8 = Module.builder()
                    .code("CS101-8")
                    .name("Machine Learning Basics")
                    .credits(3)
                    .course(course)
                    .build();

            moduleRepository.saveAll(Arrays.asList(module1, module2, module3, module4, module5, module6, module7, module8));

            Student student = Student.builder()
                    .id(1L)
                    .name("Emma Thompson")
                    .email("emma.thompson@example.com")
                    .build();
            student.setCourses(List.of(course));
            studentRepository.save(student);

            StudentModuleProgress progress1 = StudentModuleProgress.builder()
                    .student(student)
                    .module(module1)
                    .completed(true)
                    .result("Distinction")
                    .timeSpent(150)
                    .build();

            StudentModuleProgress progress2 = StudentModuleProgress.builder()
                    .student(student)
                    .module(module2)
                    .completed(true)
                    .result("Pass")
                    .timeSpent(120)
                    .build();

            StudentModuleProgress progress3 = StudentModuleProgress.builder()
                    .student(student)
                    .module(module3)
                    .completed(true)
                    .result("Fail")
                    .timeSpent(90)
                    .build();

            StudentModuleProgress progress4 = StudentModuleProgress.builder()
                    .student(student)
                    .module(module4)
                    .completed(false)
                    .result("Pending")
                    .timeSpent(60)
                    .build();

            StudentModuleProgress progress5 = StudentModuleProgress.builder()
                    .student(student)
                    .module(module5)
                    .completed(true)
                    .result("Pass")
                    .timeSpent(110)
                    .build();

            StudentModuleProgress progress6 = StudentModuleProgress.builder()
                    .student(student)
                    .module(module6)
                    .completed(true)
                    .result("Distinction")
                    .timeSpent(130)
                    .build();

            StudentModuleProgress progress7 = StudentModuleProgress.builder()
                    .student(student)
                    .module(module7)
                    .completed(false)
                    .result("Pending")
                    .timeSpent(50)
                    .build();

            StudentModuleProgress progress8 = StudentModuleProgress.builder()
                    .student(student)
                    .module(module8)
                    .completed(true)
                    .result("Distinction")
                    .timeSpent(140)
                    .build();

            progressRepository.saveAll(Arrays.asList(progress1, progress2, progress3, progress4, progress5, progress6, progress7, progress8));

            System.out.println("Seed data loaded successfully.");
        };
    }
}
