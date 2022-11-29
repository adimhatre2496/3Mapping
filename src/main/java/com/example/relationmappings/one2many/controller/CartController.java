package com.example.relationmappings.one2many.controller;

import com.example.relationmappings.one2many.model.Cart;
import com.example.relationmappings.one2many.model.CartResponse;
import com.example.relationmappings.one2many.model.Item;
import com.example.relationmappings.one2many.service.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class CartController {

    @Autowired
    private final CartService cartService;


    @PostMapping(path = "/carts", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CartResponse> createItems(@RequestBody Cart cart) {
        CartResponse cartResponse = cartService.createItems(cart);
        return new ResponseEntity<>(cartResponse, HttpStatus.OK);
    }
    @GetMapping(path = "/carts/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cart> getCart(@PathVariable Long id) {
        Cart cart = cartService.getCart(id);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }
    /*  @PutMapping(path = "/carts/{id}", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
      public ResponseEntity<Cart> updateCart(@PathVariable Long id, @RequestBody Cart cart) {
          cart = cartAndItemService.updateCart(id, cart);
          return new ResponseEntity<>(cart, HttpStatus.CREATED);
      }*/
    @DeleteMapping(path = "/carts/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable Long id){
        cartService.deleteCart(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping(path = "/carts/{id}", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateCart(@PathVariable Long id, @RequestBody Item item, @RequestParam String name)  {
        cartService.updateCart(id,item,name);
        return ResponseEntity.ok().build();
    }

}
