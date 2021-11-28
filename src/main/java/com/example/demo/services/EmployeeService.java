package com.example.demo.services;

import com.example.demo.entities.Employee;
import com.example.demo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    public Employee login(String username, String password) {
        if(username != null && password != null){
            return employeeRepository.findByUsernameAndPassword(username, password).get();
        }
        return null;
        
    }
    
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
    
    public void save(Employee employee) {
        try{
            employeeRepository.save(employee);
        }catch(Exception e){
            throw e;
        }
    }
    
    public Employee findByEmail(String email) {
        if(email != null){
            return employeeRepository.findByEmail(email).get();
        }
        return null;
    }
    
    public void delete(Employee employee) {
        try{
            employeeRepository.delete(employee);
        }catch(Exception e){
            throw e;
        }
    }
    
    public Employee findById(Long id) {
        if(id != null){
            return employeeRepository.findById(id).get();
        }
        return null;
    }
}