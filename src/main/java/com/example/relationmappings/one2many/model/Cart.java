package com.example.relationmappings.one2many.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    private String cartName;
    private List<Item> items;

}
