package com.anu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anu.dao.ShoppingCartRepository;
import com.anu.model.ShoppingCart;
import com.anu.model.User;
import com.anu.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;
    
    public ShoppingCart findByUser(User user) {
        return shoppingCartRepository.findByUser(user);
    }
    
    // Other methods for shopping cart-related operations
}