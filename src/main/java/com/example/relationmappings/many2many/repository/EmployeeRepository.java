package com.example.relationmappings.many2many.repository;

import com.example.relationmappings.many2many.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
}
