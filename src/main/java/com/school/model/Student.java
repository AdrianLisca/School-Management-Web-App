package com.school.model;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student extends BaseEntity{
    private String firstName;
    private String lastName;
}
