package com.example.relationmappings.one2many.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Item")
public class ItemEntity {
    @Id
    @SequenceGenerator(name = "seq_item_id", initialValue = 1, sequenceName = "seq_item_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_item_id")
    @Column(name = "item_id")
    private Long id;
    @Column(name = "item_name")
    private String name;
    @Column(name = "item_price")
    private Double price;
    @Column(name = "item_quantity")
    private Long quantity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="cart_id")
    private CartEntity cartEntity;
}
