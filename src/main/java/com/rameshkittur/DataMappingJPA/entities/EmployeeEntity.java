package com.rameshkittur.DataMappingJPA.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity(name = "EMPLOYEE")
@Getter
@Setter
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToOne(mappedBy = "manager")
    @JsonIgnore
    private DepartmentEntity managedDepartment;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DEPARTMENT_ID",referencedColumnName = "id")
    @JsonIgnore
    private DepartmentEntity workerDepartment;

    @ManyToMany
    @JoinTable(name = "EMPLOYEE_DEPARTMENT",
                joinColumns = @JoinColumn(name = "EMPLOYEE_ID"),
                inverseJoinColumns = @JoinColumn(name = "DEPARTMENT_ID"))
    @JsonIgnore
    private List<DepartmentEntity> freelanceDepartments;

}
