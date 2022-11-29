package com.example.relationmappings.one2one.mapper;

import com.example.relationmappings.one2one.entity.PersonEntity;
import com.example.relationmappings.one2one.model.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMappper {

    PersonEntity personToEntity(Person person);
    Person entityToPerson(PersonEntity personEntity);
}
