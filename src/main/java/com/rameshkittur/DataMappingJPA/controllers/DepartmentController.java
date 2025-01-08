package com.rameshkittur.DataMappingJPA.controllers;

import com.rameshkittur.DataMappingJPA.entities.DepartmentEntity;
import com.rameshkittur.DataMappingJPA.entities.EmployeeEntity;
import com.rameshkittur.DataMappingJPA.services.DepartmentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public DepartmentEntity createNewDepartment(@RequestBody DepartmentEntity department){
        return departmentService.createNewDepartment(department);
    }

    @GetMapping("{id}")
    public DepartmentEntity getDepartmentById(@PathVariable Long id){
        return departmentService.getDepartmentById(id);
    }

    @PutMapping("{departmentId}/manager/{managerId}")
    public DepartmentEntity assignManagerToDepartment(@PathVariable Long departmentId,
                                                      @PathVariable Long managerId ){
        return departmentService.assignManagerToDepartment(departmentId,managerId);
    }

    @PutMapping("{departmentId}/employee/{employeeId}")
    public EmployeeEntity addEmployeeToDepartment(@PathVariable Long departmentId,
                                                  @PathVariable Long employeeId){
        return departmentService.addEmployeeToDepartment(departmentId,employeeId);
    }

    @PutMapping("{departmentId}/freelancers/{employeeId}")
    public EmployeeEntity addFreelancersToDepartment(@PathVariable Long departmentId,
                                                  @PathVariable Long employeeId){
        return departmentService.addFreelancersToDepartment(departmentId,employeeId);
    }
}
