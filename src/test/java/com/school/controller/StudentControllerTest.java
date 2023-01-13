package com.school.controller;

import com.school.model.Student;
import com.school.service.StudentService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@WebMvcTest(StudentController.class)
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    private Student student;


    @BeforeEach
    void setUp() {
        student = new Student();
        student.setId(1);
        student.setUsername("Doc");
        student.setPassword("4444");
        student.setEmail("doc@gmail.com");
    }

//    @Test
//    void saveStudent() throws Exception {
//        Student inputStudent = new Student();
//        inputStudent.setUsername("Doc");
//        inputStudent.setPassword("4444");
//        inputStudent.setEmail("doc@gmail.com");
//
//        Mockito.when(studentService.saveStudent(inputStudent))
//                .thenReturn(student);
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/save/student")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("{\n" +
//                        "\t\"username\" : \"Doc\", \n" +
//                        "\t\"password\" : \"4444\", \n" +
//                        "\t\"email\" : \"doc@gmail.com\" \n" +
//                        "}"))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }

    @Test
    void getStudentById() throws Exception {
        Mockito.when(studentService.getStudentById(1))
                .thenReturn(student);

        mockMvc.perform(MockMvcRequestBuilders.get("/student/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.username",
                        Matchers.is("Doc")));
    }
}