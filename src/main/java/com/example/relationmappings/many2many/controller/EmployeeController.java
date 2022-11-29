package com.example.relationmappings.many2many.controller;

import com.example.relationmappings.many2many.model.Department;
import com.example.relationmappings.many2many.model.Employee;
import com.example.relationmappings.many2many.model.EmployeeResponse;
import com.example.relationmappings.many2many.service.EmployeeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody Employee employee) {
        EmployeeResponse employeeResponse = employeeService.createEmployee(employee);
        log.info("Post Successfull");
        return new ResponseEntity<>(employeeResponse, HttpStatus.OK);
    }
    @GetMapping(value = "/employees-department/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee employee =employeeService.getEmployeeById(id);
        log.info("Fetch Successfull");
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    @PutMapping(value = "/employees/{id}",consumes=MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateEmployeeById(@PathVariable Long id, @RequestBody Employee employee){
        employeeService.updateEmployeeById(id,employee);
        log.info("employee updated with id {} ", id);

        return ResponseEntity.ok().build();
    }
    @PutMapping(value="/departments/{id}" ,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateDepartmentById(@PathVariable Long id, @RequestBody Department department){
        employeeService.updateDepartmentById(id,department);
        log.info("department updated with id {} ", id);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping(value="/employees/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable Long id){
        employeeService.deleteEmployeeById(id);
        log.info("employee deleted with id {} ", id);

        return ResponseEntity.ok().build();
    }

}
