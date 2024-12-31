package com.rameshkittur.DataMappingJPA.services;

import com.rameshkittur.DataMappingJPA.entities.DepartmentEntity;
import com.rameshkittur.DataMappingJPA.entities.EmployeeEntity;
import com.rameshkittur.DataMappingJPA.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeEntity createNewEmployee(EmployeeEntity employee) {
      return employeeRepository.save(employee);
    }

    public EmployeeEntity getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }
}
