package com.example.relationmappings.one2many.mapper;

import com.example.relationmappings.one2many.entity.CartEntity;
import com.example.relationmappings.one2many.model.Cart;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CartMapper {

    CartEntity cartToEntity(Cart cart);

    Cart entityToModel(CartEntity cartEntity);

    List<Cart> entityToModels(List<CartEntity> cartEntities);

}
