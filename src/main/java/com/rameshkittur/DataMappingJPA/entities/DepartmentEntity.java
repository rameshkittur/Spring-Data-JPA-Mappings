package com.rameshkittur.DataMappingJPA.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "DEPARTMENT")
@Data
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @OneToOne
    @JoinColumn(name = "DEPARTMENT_MANAGER")
    private EmployeeEntity manager;
}
