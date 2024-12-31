package com.rameshkittur.DataMappingJPA.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "EMPLOYEE")
@Data
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToOne(mappedBy = "manager")
    private DepartmentEntity managedDepartment;

}
