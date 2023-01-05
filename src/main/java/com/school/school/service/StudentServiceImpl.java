package com.school.school.service;

import com.school.school.exceptions.NotFoundException;
import com.school.school.model.Student;
import com.school.school.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
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

    @Override
    public Student getStudentById(Integer studentId) {
        Optional<Student> student = studentRepository.findById(studentId);
        if(student.isEmpty()) {
            throw new NotFoundException("Student not found for ID: " + studentId);
        }
        return student.get();
    }

    @Override
    public void deleteStudentById(Integer studentId) {
        studentRepository.deleteById(studentId);
    }
}