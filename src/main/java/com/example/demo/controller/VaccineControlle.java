package com.example.demo.controller;

import com.example.demo.services.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (path = "api/v1/vaccine")
public class VaccineControlle {
    
    private final VaccineService vaccineService;
    
    @Autowired
    public VaccineControlle(VaccineService vaccineService) {
        this.vaccineService = vaccineService;
    }
}