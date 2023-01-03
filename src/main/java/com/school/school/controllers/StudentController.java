package com.school.school.controllers;

import com.school.school.models.Student;
import com.school.school.services.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping
public class StudentController {

    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/save/user")
    public Student saveStudent(@RequestBody Student newStudent) {
        return studentService.saveStudent(newStudent);
    }

    @GetMapping("/students")
    public ResponseEntity<Set<Student>> getAllStudents() {
     return ResponseEntity.ok(studentService.getStudents());
    }
}

