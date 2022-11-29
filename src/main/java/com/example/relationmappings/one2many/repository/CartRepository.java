package com.example.relationmappings.one2many.repository;

import com.example.relationmappings.one2many.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<CartEntity,Long> {
}
