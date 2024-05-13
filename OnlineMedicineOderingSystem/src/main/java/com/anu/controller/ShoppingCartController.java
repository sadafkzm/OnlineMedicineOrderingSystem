package com.anu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anu.model.ShoppingCart;
import com.anu.model.User;
import com.anu.service.ShoppingCartService;
import com.anu.service.UserService;

@RestController
@RequestMapping("/api/shopping-cart")
public class ShoppingCartController {
    
    @Autowired
    private ShoppingCartService shoppingCartService;
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/user/{username}")
    public ResponseEntity<ShoppingCart> getShoppingCartByUsername(@PathVariable String username) {
        User user = userService.findOne(username);
        if (user != null) {
            ShoppingCart shoppingCart = shoppingCartService.findByUser(user);
            return ResponseEntity.ok(shoppingCart);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
   
}