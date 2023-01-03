package com.school.school.models;

import jakarta.persistence.Entity;

@Entity
public class Teacher extends BaseEntity{
    private String firstName;
    private String lastName;
}
