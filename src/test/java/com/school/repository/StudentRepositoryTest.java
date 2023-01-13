package com.school.repository;

import com.school.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Student student = new Student();
        student.setUsername("Doc");
        student.setEmail("sheppard@gmail.com");
        student.setPassword("password");
        student.setFirstName("Jack");
        student.setLastName("Sheppard");

        entityManager.persist(student);
    }

    @Test
    public void whenFindById_thenReturnStudent() {
        Student student = studentRepository.findById(1).get();
        assertEquals(student.getUsername(), "Doc");
    }
}