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
@Table (schema = "Vaccine", name = "Customer",
        uniqueConstraints = @UniqueConstraint (columnNames = {"username"}))
public class Customer {
    @Id
    @Column (name = "customer_id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @NotNull
    private Long customerID;
    
    @Column (name = "full_name", columnDefinition = "NVARCHAR(100)")
    @NotNull
    private String fullName;
    
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
    
    @Column (name = "identity_card", columnDefinition = "NVARCHAR(255)")
    @NotNull
    private String identityCard;
    
    @OneToMany (mappedBy = "customer", fetch = FetchType.LAZY)
    @Cascade (value = {CascadeType.ALL})
    private Set<InjectionResult> injectionResults;
    
    public Customer(String fullName, String username, String password, int gender,
                    LocalDate dateOfBirth, String phone, String email, String address,
                    String identityCard) {
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.identityCard = identityCard;
    }
    
    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
    }
}