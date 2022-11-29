package com.example.relationmappings.one2many.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Cart")
public class CartEntity {
    @Id
    @SequenceGenerator(name = "seq_cart_id", initialValue = 100, sequenceName = "seq_cart_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cart_id")
    @Column(name = "cart_Id")
    private Long cartId;
    @Column(name = "cart_name")
    private String cartName;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private List<ItemEntity> items;

}
