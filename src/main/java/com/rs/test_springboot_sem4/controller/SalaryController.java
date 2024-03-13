package com.rs.test_springboot_sem4.controller;

import com.rs.test_springboot_sem4.entities.Employee;
import com.rs.test_springboot_sem4.entities.ManageSalary;
import com.rs.test_springboot_sem4.repository.ISalary;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/salary")
@RequiredArgsConstructor
public class SalaryController {

    private final ISalary iSalary;

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        try {
           return ResponseEntity.ok(iSalary.findAll());
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(ManageSalary salary){
        try {

            iSalary.save(salary);
            return ResponseEntity.ok( "create successful" );
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(ManageSalary salary){
        try {
            Optional<ManageSalary> m = iSalary.findById(salary.getId());
            if( !m.isPresent() ){
                return ResponseEntity.ok( "data not found" );
            }

            m.get().setName(salary.getName() );
            m.get().setSalary(salary.getSalary());
            m.get().setAge( salary.getAge());

            iSalary.save(m.get());
            return ResponseEntity.ok( "update successful" );
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        try {
            Optional<ManageSalary> m = iSalary.findById(id);
            if( !m.isPresent() ){
                return ResponseEntity.ok( "data not found" );
            }

            iSalary.delete(m.get());
            return ResponseEntity.ok( "delete successful" );


        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

@GetMapping("/search/{search}")
    public ResponseEntity<?> search(@PathVariable String search){
    try {

        Optional<ManageSalary> m = iSalary.findByNameContainingOrAgeContaining(search);
        if( m.isPresent() ){
            return ResponseEntity.ok(m.get());
        }

        return ResponseEntity.ok("not found data");

    }catch (Exception e){
        throw new RuntimeException(e.getMessage());
    }

}


}
