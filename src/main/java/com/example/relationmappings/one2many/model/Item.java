package com.example.relationmappings.one2many.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private String name;
    private Long quantity;
    private Double price;
}
