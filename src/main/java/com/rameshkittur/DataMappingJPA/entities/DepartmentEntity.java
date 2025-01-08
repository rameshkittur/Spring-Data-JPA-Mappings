package com.rameshkittur.DataMappingJPA.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity(name = "DEPARTMENT")
@Getter
@Setter
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @OneToOne
    @JoinColumn(name = "DEPARTMENT_MANAGER")
    private EmployeeEntity manager;

    @OneToMany(mappedBy = "workerDepartment")
    private Set<EmployeeEntity> employees;

    @ManyToMany(mappedBy = "freelanceDepartments")
    private Set<EmployeeEntity>freelancers;
}
