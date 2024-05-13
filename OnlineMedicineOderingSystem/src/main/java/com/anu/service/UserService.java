package com.anu.service;

import java.util.List;
import java.util.Set;

import com.anu.exception.UserFoundException;
import com.anu.model.User;
import com.anu.model.UserDto;



public interface UserService {
	User save(UserDto user);
    List<User> findAll();
    User findOne(String username);
}
