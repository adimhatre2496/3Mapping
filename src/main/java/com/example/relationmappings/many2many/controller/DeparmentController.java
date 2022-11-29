package com.example.relationmappings.many2many.controller;

import com.example.relationmappings.many2many.model.Department;
import com.example.relationmappings.many2many.model.DepartmentResponse;
import com.example.relationmappings.many2many.service.DepartmentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class DeparmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping(value = "/departments", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DepartmentResponse> createEmployee(@RequestBody Department department) {
        DepartmentResponse departmentResponse = departmentService.createEmployee(department);
        log.info("Records inserted in department successfully");
        return new ResponseEntity<>(departmentResponse, HttpStatus.OK);
    }
}
