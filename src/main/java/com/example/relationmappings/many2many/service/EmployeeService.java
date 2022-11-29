package com.example.relationmappings.many2many.service;

import com.example.relationmappings.many2many.entity.DepartmentEntity;
import com.example.relationmappings.many2many.entity.EmployeeEntity;
import com.example.relationmappings.many2many.mapper.DepartmentMapper;
import com.example.relationmappings.many2many.mapper.EmployeeMapper;
import com.example.relationmappings.many2many.model.Department;
import com.example.relationmappings.many2many.model.Employee;
import com.example.relationmappings.many2many.model.EmployeeResponse;
import com.example.relationmappings.many2many.repository.DepartmentRepository;
import com.example.relationmappings.many2many.repository.EmployeeRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@Log4j2
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private DepartmentMapper departmentMapper;

    public EmployeeResponse createEmployee(Employee employee) {
        EmployeeResponse employeeResponse = new EmployeeResponse();
        EmployeeEntity employeeEntity = employeeMapper.employeeToEntity(employee);
        employeeRepository.save(employeeEntity);
        log.info("employee created successfully!");
        employeeResponse.setId(employeeEntity.getId());
        return employeeResponse;
    }


    public Employee getEmployeeById(Long id) {

        Optional<EmployeeEntity> optionalEmployeeEntity = employeeRepository.findById(id);
        Employee employee = new Employee();
        if (optionalEmployeeEntity.isPresent()) {
            EmployeeEntity employeeEntity = optionalEmployeeEntity.get();
            employee = employeeMapper.entityToEmployee(employeeEntity);
            log.info("employee found with id {} ", id);
        } else {
            log.info("employee id {} ", id + "not found");
        }
        return employee;
    }

    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
        log.info("employee id {} ", id + "deleted successfully");
    }

    public void updateEmployeeById(Long id, Employee employee) {
        Optional<EmployeeEntity> optionalEmployeeEntity = employeeRepository.findById(id);
        if (optionalEmployeeEntity.isPresent()) {
            optionalEmployeeEntity.get().setFirstName(employee.getFirstName());
            optionalEmployeeEntity.get().setLastName(employee.getLastName());
            employeeRepository.save(optionalEmployeeEntity.get());
            log.info("Updating..");
        } else {
            log.info("employee id {} ", id + "not found");
        }
    }

    public void updateDepartmentById(Long id, Department department) {
        Optional<DepartmentEntity> optionalDepartmentEntity = departmentRepository.findById(id);
        if (optionalDepartmentEntity.isPresent()) {
            optionalDepartmentEntity.get().setName(department.getName());
            departmentRepository.save(optionalDepartmentEntity.get());
            log.info("Updating..");
        } else {
            log.info("department id {} ", id + "not found");

        }
    }


}
