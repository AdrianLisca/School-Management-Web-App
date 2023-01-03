package com.school.school.services;

import com.school.school.models.Student;

import java.util.Set;

public interface StudentService {
    Student saveStudent(Student newStudent);

    Set<Student> getStudents();
}
