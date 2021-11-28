package com.example.demo.entities;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table (schema = "Vaccine", name = "Injection_Schedule")
public class InjectionSchedule {
	
	@Id
	@Column (name = "injection_schedule_id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@NotNull
	private Long scheduleID;
	
	@Column (name = "start_date", columnDefinition = "DATE")
	@NotNull
	private LocalDate startDate;
	
	@Column (name = "end_date", columnDefinition = "DATE")
	@NotNull
	private LocalDate endDate;
	
	@Column (name = "status", columnDefinition = "NVARCHAR(10)")
	@NotNull
	private String status;
	
	@Column (name = "place", columnDefinition = "NVARCHAR(255)")
	@NotNull
	private String place;
	
	@Column (name = "description", columnDefinition = "NVARCHAR(1000)")
	private String description;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (name = "vaccine_id", referencedColumnName = "vaccine_id")
	private Vaccine vaccine;
	
	public InjectionSchedule(LocalDate startDate, LocalDate endDate, String status, String place, String description,
							 Vaccine vaccine) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.place = place;
		this.description = description;
		this.vaccine = vaccine;
	}
}