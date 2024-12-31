package com.rameshkittur.DataMappingJPA.controllers;

import com.rameshkittur.DataMappingJPA.entities.DepartmentEntity;
import com.rameshkittur.DataMappingJPA.entities.EmployeeEntity;
import com.rameshkittur.DataMappingJPA.services.DepartmentService;
import com.rameshkittur.DataMappingJPA.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity employee){
        return employeeService.createNewEmployee(employee);
    }

    @GetMapping("{id}")
    public EmployeeEntity getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }
}
