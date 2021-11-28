package com.example.demo.entities;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table (schema = "Vaccine", name = "Employee", uniqueConstraints = @UniqueConstraint (columnNames = {"username"}))
public class Employee {
	
	@Id
	@Column (name = "employee_id")
	@NotNull
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long employeeID;
	
	@Column (name = "employee_name", columnDefinition = "NVARCHAR(100)")
	@NotNull
	private String employeeName;
	
	@Column (name = "username", columnDefinition = "NVARCHAR(255)")
	private String username;
	
	@Column (name = "password", columnDefinition = "NVARCHAR(255)")
	private String password;
	
	@Column (name = "gender", columnDefinition = "INT")
	@NotNull
	private int gender;
	
	@Column (name = "date_of_birth", columnDefinition = "DATE")
	@NotNull
	private LocalDate dateOfBirth;
	
	@Column (name = "phone", columnDefinition = "NVARCHAR(20)")
	@NotNull
	private String phone;
	
	@Column (name = "email", columnDefinition = "NVARCHAR(100)")
	@NotNull
	private String email;
	
	@Column (name = "address", columnDefinition = "NVARCHAR(255)")
	@NotNull
	private String address;
	
	@Column (name = "image", columnDefinition = "NVARCHAR(255)")
	private String image;
	
	@Column (name = "position", columnDefinition = "NVARCHAR(100)")
	@NotNull
	private String position;
	
	@Column (name = "working_place", columnDefinition = "NVARCHAR(255)")
	private String workingPlace;
	
	public Employee(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public Employee(Long employeeid, String employeeName, int gender, LocalDate dob, String phone, String address,
					String email, String workplace, String position, String image) {
		this.employeeID = employeeid;
		this.employeeName = employeeName;
		this.gender = gender;
		this.dateOfBirth = dob;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.workingPlace = workplace;
		this.position = position;
		this.image = image;
	}
}