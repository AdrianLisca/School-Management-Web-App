package com.school.controller;

import com.school.model.Student;
import com.school.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
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
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentService.getStudents());
        return "students";
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

    @PutMapping("/student/{id}")
    public Student updateStudent(@PathVariable("id") Integer studentId,
                                 @RequestBody Student student) {
        return studentService.updateStudent(studentId, student);
    }

    @GetMapping("/student/name/{name}")
    public Student getStudentByUsername(@PathVariable("name") String username) {
        return studentService.getStudentByUsername(username);
    }
}

