package com.example.relationmappings.one2many.repository;

import com.example.relationmappings.one2many.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity,Long> {
    ItemEntity findByName(String name);
}
