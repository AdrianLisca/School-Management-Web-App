package com.school.h2database;

import com.school.model.Admin;
import com.school.model.Student;
import com.school.model.Subject;
import com.school.repository.AdminRepository;
import com.school.repository.StudentRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Component
public class InitialData implements ApplicationListener<ContextRefreshedEvent> {

    private final AdminRepository adminRepository;
    private final StudentRepository studentRepository;

    public InitialData(AdminRepository adminRepository, StudentRepository studentRepository) {
        this.adminRepository = adminRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        studentRepository.saveAll(addStudents());
    }

    private List<Student> addStudents() {

        List<Student> students = new ArrayList<>();

        Student johnny = new Student();
        johnny.setUsername("johnny12");
        johnny.setPassword("jdfkj33");
        johnny.setEmail("johnny@gmail.com");
        johnny.setFirstName("Johnny");
        johnny.setLastName("DEPP");

//        Subject history = new Subject();
//        history.setName("History");
//        Subject english = new Subject();
//        english.setName("English");
//        Subject chemistry = new Subject();
//        chemistry.setName("Chemistry");
//
//        johnny.addSubject(history);
//        johnny.addSubject(english);
//        johnny.addSubject(chemistry);

        Student jack = new Student();
        jack.setUsername("doc");
        jack.setPassword("jdf434333");
        jack.setEmail("jack@gmail.com");
        jack.setFirstName("Jack");
        jack.setLastName("SHEPPARD");

        Student kate = new Student();
        kate.setUsername("kateaus");
        kate.setPassword("jdfffdfd33");
        kate.setEmail("kate@gmail.com");
        kate.setFirstName("Kate");
        kate.setLastName("AUSTIN");

        students.add(johnny);
        students.add(jack);
        students.add(kate);

        return students;
    }

}
