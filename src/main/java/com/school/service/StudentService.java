package com.school.service;

import com.school.model.Student;

import java.util.Set;

public interface StudentService {
    Student saveStudent(Student newStudent);
    Set<Student> getStudents();
    Student getStudentById(Integer studentId);
    void deleteStudentById(Integer studentId);
    Student updateStudent(Integer studentId, Student student);
    Student getStudentByUsername(String username);

}
