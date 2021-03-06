package com.example.demo.repositories;


import com.example.demo.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
    Optional<Employee> findByUsernameAndPassword(String username, String password);
    
    Optional<Employee> findByEmail(String email);
}