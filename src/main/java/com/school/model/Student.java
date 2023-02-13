package com.school.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student extends BaseEntity{
    @NotBlank(message="Field must not be blank")
    @Size(min = 4, message = "The first name must be at least 4 characters long!")
    private String firstName;

    @NotBlank(message="Field must not be blank")
    @Size(min = 4, message = "The last name must be at least 4 characters long!")
    private String lastName;

    @OneToMany(mappedBy = "student")
    private Set<Subject> subjectList = new HashSet<>();
    
    public void addSubject(Subject subject) {
        this.subjectList.add(subject);
    }
}
