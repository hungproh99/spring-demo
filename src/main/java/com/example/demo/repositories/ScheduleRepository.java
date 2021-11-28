package com.example.demo.repositories;

import com.example.demo.entities.InjectionSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<InjectionSchedule, Long> {
    String Q_FIND_SCHEDULE_AND_VACCINE =
            "SELECT s.scheduleID, v.vaccineName, s.startDate, s.endDate, s.place, s.status, s.description " +
            "FROM InjectionSchedule s INNER JOIN s.vaccine v";
    String Q_FIND_SCHEDULE_BY_ID =
            "SELECT s.scheduleID, v.vaccineID ,v.vaccineName, s.startDate, s.endDate, s.place, s.status, s.description " +
            "FROM InjectionSchedule s INNER JOIN s.vaccine v " +
            "WHERE s.scheduleID = : scheduleID";
    
    @Query (Q_FIND_SCHEDULE_AND_VACCINE)
    List<Object[]> findScheduleAndVaccine();
    
    @Query (Q_FIND_SCHEDULE_BY_ID)
    List<Object[]> findScheduleByID(int id);
}