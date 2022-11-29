package com.example.relationmappings.one2one.repository;

import com.example.relationmappings.one2one.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity,Long> {
}
