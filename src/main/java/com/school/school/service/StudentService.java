package com.school.school.service;

import com.school.school.model.Student;

import java.util.Set;

public interface StudentService {
    Student saveStudent(Student newStudent);
    Set<Student> getStudents();
    Student getStudentById(Integer studentId);

    void deleteStudentById(Integer studentId);
}
