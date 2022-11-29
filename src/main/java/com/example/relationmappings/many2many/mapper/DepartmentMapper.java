package com.example.relationmappings.many2many.mapper;

import com.example.relationmappings.many2many.entity.DepartmentEntity;
import com.example.relationmappings.many2many.model.Department;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    Department entityToDepartment(DepartmentEntity departmentEntity);

    DepartmentEntity departmentToEntity(Department department);
}
