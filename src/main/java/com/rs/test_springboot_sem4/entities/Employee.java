package com.rs.test_springboot_sem4.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "employee")
@Data
@RequiredArgsConstructor
public class Employee {

    @Id
    private String employee_id;

    private String employee_name;

    private Date birthday;

    private String phone_number;

    private String email;

}
