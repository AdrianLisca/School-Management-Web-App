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
        adminRepository.save(createAdmin());
        studentRepository.saveAll(addStudents());
    }

    private Admin createAdmin() {
        Admin newAdmin = new Admin();
        newAdmin.setUsername("Admin");
        newAdmin.setPassword(generatePassword());
        newAdmin.setEmail("school_admin@gmail.com");
        return newAdmin;
    }

    private List<Student> addStudents() {

        List<Student> students = new ArrayList<>();

        Student johnny = new Student();
        johnny.setUsername("johnny12");
        johnny.setPassword("jdfkj33");
        johnny.setEmail("johnny@gmail.com");
        johnny.setFirstName("Johnny");
        johnny.setLastName("DEPP");

        Subject history = new Subject();
        history.setName("History");
        Subject english = new Subject();
        english.setName("English");
        Subject chemistry = new Subject();
        chemistry.setName("Chemistry");

        johnny.addSubject(history);
        johnny.addSubject(english);
        johnny.addSubject(chemistry);

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

    // it generates a password with a length between 6 and 12 characters
    private String generatePassword() {
        Random random = new Random();
        String alphabetLowerCase = "abcdefghijklmnopqrstuvwxyz";
        String alphabetUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digits = "0987654321";
        String specialChars = "!@#$%^&*+-";
        String allCharacters = alphabetLowerCase + alphabetUpperCase + digits + specialChars;

        List<Character> passwordChars = new ArrayList<>();
        passwordChars.add(alphabetLowerCase.charAt(random.nextInt(alphabetLowerCase.length())));
        passwordChars.add(alphabetUpperCase.charAt(random.nextInt(alphabetUpperCase.length())));
        passwordChars.add(digits.charAt(random.nextInt(digits.length())));
        passwordChars.add(specialChars.charAt(random.nextInt(specialChars.length())));

        int minLength = 2;
        int maxLength = 8;
        int length = random.nextInt(maxLength - minLength + 1) + minLength;
        for(int i=0; i<length; i++) {
            passwordChars.add(allCharacters.charAt(random.nextInt(allCharacters.length())));
        }
        Collections.shuffle(passwordChars);
        StringBuilder password = new StringBuilder();
        passwordChars.forEach(password::append);
        return password.toString();
    }
}
