package com.example.relationmappings.many2many.service;

import com.example.relationmappings.many2many.entity.DepartmentEntity;
import com.example.relationmappings.many2many.mapper.DepartmentMapper;
import com.example.relationmappings.many2many.model.Department;
import com.example.relationmappings.many2many.model.DepartmentResponse;
import com.example.relationmappings.many2many.repository.DepartmentRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private DepartmentRepository departmentRepository;

    public DepartmentResponse createEmployee(Department department) {
        DepartmentResponse departmentResponse = new DepartmentResponse();
        DepartmentEntity departmentEntity = departmentMapper.departmentToEntity(department);
        departmentRepository.save(departmentEntity);
        log.info("Inserting....");
        departmentResponse.setId(departmentEntity.getId());
        return departmentResponse;
    }
}
