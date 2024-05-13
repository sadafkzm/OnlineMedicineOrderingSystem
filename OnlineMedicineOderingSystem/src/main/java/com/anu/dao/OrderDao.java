package com.anu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anu.model.Order;

@Repository
public interface OrderDao extends JpaRepository<Order, Long> {
   
}