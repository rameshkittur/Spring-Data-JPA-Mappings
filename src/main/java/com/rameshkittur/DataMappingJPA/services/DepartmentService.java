package com.rameshkittur.DataMappingJPA.services;

import com.rameshkittur.DataMappingJPA.entities.DepartmentEntity;
import com.rameshkittur.DataMappingJPA.entities.EmployeeEntity;
import com.rameshkittur.DataMappingJPA.repositories.DepartmentRepository;
import com.rameshkittur.DataMappingJPA.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    private final EmployeeRepository employeeRepository;

    public DepartmentService(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    public DepartmentEntity createNewDepartment(DepartmentEntity department) {
       return departmentRepository.save(department);
    }

    public DepartmentEntity getDepartmentById(Long id){
        return departmentRepository.findById(id).orElse(null);
    }

    public DepartmentEntity assignManagerToDepartment(Long departmentId, Long managerId) {
        Optional<DepartmentEntity>departmentEntity = departmentRepository.findById(departmentId);
        Optional<EmployeeEntity>employeeEntity = employeeRepository.findById(managerId);

        return departmentEntity.flatMap(department ->
            employeeEntity.map(employee -> {
                department.setManager(employee);
            return departmentRepository.save(department);
        })).orElse(null);
    }

    public EmployeeEntity addEmployeeToDepartment(Long departmentId, Long employeeId) {
        Optional<DepartmentEntity> departmentEntity = departmentRepository.findById(departmentId);
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(employeeId);

        return departmentEntity.flatMap(department ->
                employeeEntity.map(employee -> {
                    employee.setWorkerDepartment(department);
                    return employeeRepository.save(employee);
                })).orElse(null);

    }

    public EmployeeEntity addFreelancersToDepartment(Long departmentId, Long employeeId) {
        Optional<DepartmentEntity> departmentEntity = departmentRepository.findById(departmentId);
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(employeeId);

        return departmentEntity.flatMap(department ->
                employeeEntity.map(employee -> {
                    employee.getFreelanceDepartments().add(department);
                    return employeeRepository.save(employee);
                })).orElse(null);
    }
}
