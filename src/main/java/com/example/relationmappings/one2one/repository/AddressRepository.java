package com.example.relationmappings.one2one.repository;

import com.example.relationmappings.one2one.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity,Long> {
}
