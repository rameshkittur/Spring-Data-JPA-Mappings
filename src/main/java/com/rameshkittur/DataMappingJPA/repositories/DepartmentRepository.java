package com.rameshkittur.DataMappingJPA.repositories;

import com.rameshkittur.DataMappingJPA.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long> {
}
