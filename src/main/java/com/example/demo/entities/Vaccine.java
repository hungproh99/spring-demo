package com.example.demo.entities;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table (schema = "Vaccine", name = "Vaccine")
public class Vaccine {
	
	@Id
	@Column (name = "vaccine_id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long vaccineID;
	
	@Column (name = "vaccine_name", columnDefinition = "NVARCHAR(100)")
	@NotNull
	private String vaccineName;
	
	@Column (name = "contraindication", columnDefinition = "NVARCHAR(200)")
	private String contraindication;
	
	@Column (name = "indiaction", columnDefinition = "NVARCHAR(200)")
	private String indiaction;
	
	@Column (name = "number_of_injection", columnDefinition = "INT")
	private int numberOfInjection;
	
	@Column (name = "origin", columnDefinition = "NVARCHAR(50)")
	private String origin;
	
	@Column (name = "time_begin_next_injection", columnDefinition = "DATE")
	private LocalDate timeBeginNextInjection;
	
	@Column (name = "time_end_next_injection", columnDefinition = "DATE")
	private LocalDate timeEndNextInjection;
	
	@Column (name = "usage", columnDefinition = "NVARCHAR(200)")
	private String usage;
	
	@Column (name = "active", columnDefinition = "INT")
	@NotNull
	private int active;
	
	@OneToMany (mappedBy = "vaccine", fetch = FetchType.LAZY)
	@Cascade (value = {CascadeType.ALL})
	private Set<InjectionResult> injectionResults;
	
	@OneToMany (mappedBy = "vaccine", fetch = FetchType.LAZY)
	@Cascade (value = {CascadeType.ALL})
	private Set<InjectionSchedule> injectionSchedules;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (name = "vaccine_type_id", referencedColumnName = "vaccine_type_id")
	private VaccineType vaccineType;
	
	public Vaccine(Long vaccineID, String vaccineName, String contraindication, String indiaction,
				   int numberOfInjection, String origin, LocalDate timeBeginNextInjection,
				   LocalDate timeEndNextInjection, String usage, int active) {
		this.vaccineID = vaccineID;
		this.vaccineName = vaccineName;
		this.contraindication = contraindication;
		this.indiaction = indiaction;
		this.numberOfInjection = numberOfInjection;
		this.origin = origin;
		this.timeBeginNextInjection = timeBeginNextInjection;
		this.timeEndNextInjection = timeEndNextInjection;
		this.usage = usage;
		this.active = active;
	}
}