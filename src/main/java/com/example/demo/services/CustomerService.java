package com.example.demo.services;

import com.example.demo.entities.Customer;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;
    
    public Customer login(String username, String password) {
        if(username != null && password != null){
            return customerRepository.findByUsernameAndPassword(username, password).get();
        }
        return null;
    }
}