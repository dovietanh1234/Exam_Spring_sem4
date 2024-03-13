package com.rs.test_springboot_sem4.repository;

import com.rs.test_springboot_sem4.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmplyee extends JpaRepository<Employee, String> {
    Employee findByEmployee_id(String name);
}
