package com.example.demo.entities;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table (schema = "Vaccine", name = "Vaccine_Type")
public class VaccineType {
    
    @Id
    @Column (name = "vaccine_type_id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @NotNull
    private Long vaccineTypeID;
    
    @Column (name = "vaccine_type_name", columnDefinition = "NVARCHAR(50)")
    @NotNull
    private String vaccineTypeName;
    
    @Column (name = "description", columnDefinition = "NVARCHAR(200)")
    @NotNull
    private String description;
    
    @Column (name = "active", columnDefinition = "INT")
    @NotNull
    private int active;
    
    
    @Column (name = "image", columnDefinition = "NVARCHAR(255)")
    private String image;
    
    @OneToMany (mappedBy = "vaccineType", fetch = FetchType.LAZY)
    @Cascade (value = {CascadeType.ALL})
    @ToString.Exclude
    private Set<Vaccine> vaccines;
    
    
    @Override
    public boolean equals(Object o) {
        if(this == o){
            return true;
        }
        if(o == null || Hibernate.getClass(this) != Hibernate.getClass(o)){
            return false;
        }
        VaccineType that = (VaccineType) o;
        return vaccineTypeID != null && Objects.equals(vaccineTypeID, that.vaccineTypeID);
    }
    
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}