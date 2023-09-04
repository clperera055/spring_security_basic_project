package com.nicompany.employeesystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private int id;
    private String email;
    private String password;
    private String role;

    public Employee(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
