package com.school.service;

import com.school.exceptions.NotFoundException;
import com.school.model.Student;
import com.school.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.*;

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
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        // students.addAll(studentRepository.findAll());
        studentRepository.findAllByOrderByIdAsc().iterator().forEachRemaining(students::add);
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

    @Override
    public Student updateStudent(Integer studentId, Student student) {
        Student studentDB = getStudentById(studentId);

        if(Objects.nonNull(student.getUsername()) &&
                !"".equalsIgnoreCase(student.getUsername())) {
            studentDB.setUsername(student.getUsername());
        }

        if(Objects.nonNull(student.getEmail()) &&
                !"".equalsIgnoreCase(student.getEmail())) {
            studentDB.setEmail(student.getEmail());
        }

        if(Objects.nonNull(student.getFirstName()) &&
                !"".equalsIgnoreCase(student.getFirstName())) {
            studentDB.setFirstName(student.getFirstName());
        }

        if(Objects.nonNull(student.getLastName()) &&
                !"".equalsIgnoreCase(student.getLastName())) {
            studentDB.setLastName(student.getLastName());
        }

        return studentRepository.save(studentDB);
    }

    @Override
    public Student getStudentByUsername(String username) {
        Student student = studentRepository.findByUsername(username);
        if(student == null) {
            throw new NotFoundException("Student not found for username: " + username);
        }
        return student;
    }
}
