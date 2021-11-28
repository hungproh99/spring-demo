package com.example.demo.services;


import com.example.demo.entities.InjectionSchedule;
import com.example.demo.repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {
    
    @Autowired
    private ScheduleRepository scheduleRepository;
    
    public void save(InjectionSchedule schedule) {
        if((schedule == null) || (schedule.getVaccine() == null)){
            throw new IllegalArgumentException();
        }
        scheduleRepository.save(schedule);
    }
    
    public List<InjectionSchedule> findAll() {
        return scheduleRepository.findAll();
    }
    
    public List<Object[]> findScheduleAndVaccine() {
        return scheduleRepository.findScheduleAndVaccine();
    }
    
    public List<Object[]> findScheduleByID(int id) {
        if(id <= 0){
            throw new IllegalArgumentException();
        }
        return scheduleRepository.findScheduleByID(id);
    }
    
}