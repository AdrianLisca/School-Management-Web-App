package com.school.controller;

import com.school.model.Student;
import com.school.model.Subject;
import com.school.repository.SubjectRepository;
import com.school.service.StudentService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
@Slf4j
public class StudentController {

    private final StudentService studentService;

    private final SubjectRepository subjectRepository;

    public StudentController(StudentService studentService, SubjectRepository subjectRepository) {
        this.studentService = studentService;
        this.subjectRepository = subjectRepository;
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
                                 @Valid @ModelAttribute("student") Student student,
                                Errors errors) {
        if(errors.hasErrors()) {
            log.error("Student update form validation failed due to: " + errors.toString());
            return "edit_student";
        }
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
    public String detailsStudentForm(@PathVariable Integer id, ModelMap model) {
        Student student = studentService.getStudentById(id);
        System.out.println(student.getSubjectList());
        model.addAttribute("student", student);
        model.addAttribute("subject", new Subject());
        return "details_student";
    }

    @PostMapping("/students/details/{id}")
    public String addSubject(@PathVariable("id") Integer id,
                             @ModelAttribute("subject") Subject subject) {
        Student student = studentService.getStudentById(id);
        subject.setStudent(student);
        return "redirect:/students/details/{id}";
    }
}

