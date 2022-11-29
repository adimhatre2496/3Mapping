package com.example.relationmappings.many2many.mapper;

import com.example.relationmappings.many2many.entity.EmployeeEntity;
import com.example.relationmappings.many2many.model.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    Employee entityToEmployee(EmployeeEntity employeeEntity);

    EmployeeEntity employeeToEntity(Employee employee);
}
