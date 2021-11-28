package com.example.demo.services;


import com.example.demo.entities.VaccineType;
import com.example.demo.repositories.VaccineTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccineTypeService {
    
    @Autowired
    private VaccineTypeRepository typeRepository;
    
    public void save(VaccineType vaccineType) {
        if(vaccineType == null){
            throw new IllegalArgumentException();
        }
        typeRepository.save(vaccineType);
    }
    
    
    public List<VaccineType> findAll() {
        return typeRepository.findAll();
    }
    
    
    public VaccineType findByID(Long ID) {
        try{
            return typeRepository.findById(ID).get();
        }catch(Exception e){
            throw e;
        }
    }
    
    public void delete(Long ID) {
        boolean exists = typeRepository.existsById(ID);
        if(exists){
            typeRepository.deleteById(ID);
        }else{
            throw new IllegalStateException("ID not exists!");
        }
    }
}