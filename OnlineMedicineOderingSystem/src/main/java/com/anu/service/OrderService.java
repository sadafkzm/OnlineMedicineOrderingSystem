package com.anu.service;

import com.anu.model.Order;

public interface OrderService {
	public Order createOrder(Long userId);
	public Order getOrderById(Long orderId);
}
