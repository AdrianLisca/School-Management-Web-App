package com.school.school.services;

import com.school.school.models.BaseEntity;
import com.school.school.models.Student;
import com.school.school.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(Student newStudent) {

        Student student = new Student();

        student.setUsername(newStudent.getUsername());
        student.setPassword(newStudent.getPassword());
        student.setEmail(newStudent.getEmail());
        student.setFirstName(newStudent.getFirstName());
        student.setLastName(newStudent.getLastName());

        return studentRepository.save(student);
    }

    @Override
    public Set<Student> getStudents() {
        Set<Student> students = new HashSet<>();
        studentRepository.findAll().iterator().forEachRemaining(students::add);
        return students;
    }
}
