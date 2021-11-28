package com.example.demo.entities;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table (schema = "Vaccine", name = "Injection_Result")
public class InjectionResult {
	@Id
	@Column (name = "injection_result_id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@NotNull
	private Long injectionResultID;
	
	@Column (name = "injection_date", columnDefinition = "DATE")
	private LocalDate injectionDate;
	
	@Column (name = "injection_place", columnDefinition = "NVARCHAR(255)")
	private String injectionPlace;
	
	@Column (name = "next_injection_date", columnDefinition = "DATE")
	private LocalDate nextInjectionDate;
	
	@Column (name = "number_of_injection", columnDefinition = "NVARCHAR(100)")
	private String numberOfInjection;
	
	@Column (name = "prevention", columnDefinition = "NVARCHAR(100)")
	private String prevention;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (name = "customer_id", referencedColumnName = "customer_id")
	private Customer customer;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (name = "vaccine_id", referencedColumnName = "vaccine_id")
	private Vaccine vaccine;
	
	public InjectionResult(LocalDate injectionDate, String injectionPlace, LocalDate nextInjectionDate,
						   String numberOfInjection, String prevention) {
		this.injectionDate = injectionDate;
		this.injectionPlace = injectionPlace;
		this.nextInjectionDate = nextInjectionDate;
		this.numberOfInjection = numberOfInjection;
		this.prevention = prevention;
	}
}