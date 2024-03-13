package com.rs.test_springboot_sem4.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "salary")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManageSalary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "employee name is mandatory")
    private String name;
    @NotBlank(message = "employee age is mandatory")
    private String age;
    @NotBlank(message = "employee salary is mandatory")
    private int salary;

}

/*
* @Email(message = "Email should be valid")
* @NotNull(message = "Birthday is mandatory")
* */
