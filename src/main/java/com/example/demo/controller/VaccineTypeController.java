package com.example.demo.controller;

import com.example.demo.entities.VaccineType;
import com.example.demo.services.VaccineTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.annotation.MultipartConfig;
import java.util.List;

@MultipartConfig
@RestController
@RequestMapping (path = "api/v1/vactype")
public class VaccineTypeController {
    
    private final VaccineTypeService vaccineTypeService;
    
    @Autowired
    public VaccineTypeController(VaccineTypeService vaccineTypeService) {
        this.vaccineTypeService = vaccineTypeService;
    }
    
    @GetMapping
    public List<VaccineType> findAllVaccinesTypes() {
        return vaccineTypeService.findAll();
    }
    
    @PostMapping
    public void addVaccineType(@RequestBody VaccineType vaccineType) {
        System.out.println(vaccineType);
        vaccineTypeService.save(vaccineType);
    }
    
    @DeleteMapping (path = "{id}")
    public void deleteVaccineType(@PathVariable ("id") Long ID) {
        vaccineTypeService.delete(ID);
    }
}