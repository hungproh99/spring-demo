package com.example.demo.services;


import com.example.demo.entities.Vaccine;
import com.example.demo.repositories.VaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccineService {
    
    @Autowired
    private VaccineRepository vaccineRepository;
    
    public List<Vaccine> findAll() {
        return vaccineRepository.findAll();
    }
    
    public Vaccine findById(Long id) {
        return vaccineRepository.findById(id).get();
    }
    
    public void save(Vaccine vaccine) {
        vaccineRepository.save(vaccine);
    }
}