package com.school.model;

import jakarta.persistence.Entity;

@Entity
public class Teacher extends BaseEntity{
    private String firstName;
    private String lastName;
}
