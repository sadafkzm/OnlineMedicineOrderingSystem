package com.anu.service;

import com.anu.model.ShoppingCart;
import com.anu.model.User;

public interface ShoppingCartService {
	

	public ShoppingCart findByUser(User user);
}
