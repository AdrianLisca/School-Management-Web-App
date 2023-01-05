package com.school.school.controller;

import com.school.school.model.Student;
import com.school.school.service.StudentService;
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

    @PostMapping("/save/student")
    public Student saveStudent(@RequestBody Student newStudent) {
        return studentService.saveStudent(newStudent);
    }

    @GetMapping("/students")
    public ResponseEntity<Set<Student>> getAllStudents() {
     return ResponseEntity.ok(studentService.getStudents());
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable("id") Integer studentId) {
        return studentService.getStudentById(studentId);
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudentById(@PathVariable("id") Integer studentId) {
        studentService.deleteStudentById(studentId);
        return "Student with ID " + studentId + " deleted successfully!";
    }
}

