package com.example.demo.controller;

import com.example.demo.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (path = "api/v1/schedule")
public class InjectionScheduleController {
    
    private final ScheduleService scheduleService;
    
    @Autowired
    public InjectionScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }
    
    @GetMapping ("/list")
    public List<Object[]> getList() {
        return scheduleService.findScheduleAndVaccine();
    }
}