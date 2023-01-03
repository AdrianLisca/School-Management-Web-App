package com.school.school.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Student extends BaseEntity{
    private String firstName;
    private String lastName;
}
