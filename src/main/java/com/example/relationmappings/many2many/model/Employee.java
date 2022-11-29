package com.example.relationmappings.many2many.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private String firstName;
    private String lastName;
    private Set<Department> department;
}
