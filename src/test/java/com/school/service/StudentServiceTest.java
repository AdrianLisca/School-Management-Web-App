package com.school.service;


import com.school.model.Student;
import com.school.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @InjectMocks
    private StudentServiceImpl studentService;

    @Mock
    private StudentRepository studentRepository;

    private Student student;

    @BeforeEach
    void setUp() {
        student = new Student();
        student.setUsername("Doc");
        student.setEmail("sheppard@gmail.com");
        student.setPassword("password");
        student.setFirstName("Jack");
        student.setLastName("Sheppard");

    }

    @Test
    @DisplayName("JUnit test for getStudentByUsername method")
    public void givenStudentUsername_whenGetStudentByUsername_thenReturnStudentObject() {
        given(studentRepository.findByUsername("Doc")).willReturn(student);

        Student savedStudent = studentService.getStudentByUsername("Doc");

        assertThat(savedStudent).isNotNull();
        assertThat(savedStudent.getLastName()).isEqualTo("Sheppard");
        assertThat(savedStudent).isEqualTo(student);
    }
}