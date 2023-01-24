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

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
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

    @GetMapping("/students/{id}")
    public String deleteStudentById(@PathVariable("id") Integer id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Integer id,
                                 @ModelAttribute("student") Student student,
                                Model model) {
        studentService.updateStudent(id, student);
        return "redirect:/students";
    }

    @GetMapping("/student/name/{name}")
    public Student getStudentByUsername(@PathVariable("name") String username) {
        return studentService.getStudentByUsername(username);
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Integer id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }

    @GetMapping("/students/details/{id}")
    public String detailsStudentForm(@PathVariable Integer id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "details_student";
    }

}

