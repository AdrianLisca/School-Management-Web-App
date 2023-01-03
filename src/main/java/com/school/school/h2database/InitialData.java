package com.school.school.h2database;

import com.school.school.models.Admin;
import com.school.school.repositories.AdminRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class InitialData implements ApplicationListener<ContextRefreshedEvent> {

    private final AdminRepository adminRepository;

    public InitialData(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        adminRepository.save(createAdmin());
    }

    private Admin createAdmin() {
        Admin newAdmin = new Admin();
        newAdmin.setUsername("Admin");
        newAdmin.setPassword("Fd89!#kfjd");
        newAdmin.setEmail("school_admin@gmail.com");
        return newAdmin;
    }
}
