package com.school.school.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank
    @Size(max = 20)
    @Setter
    @Getter
    private String username;

    @NotBlank
    @Size(max = 20)
    @Setter
    @Getter
    private String password;

    @NotBlank
    @Setter
    @Getter
    private String email;

    public BaseEntity() {}

    public BaseEntity(Integer id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
