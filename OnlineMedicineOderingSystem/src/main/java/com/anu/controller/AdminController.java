package com.anu.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.anu.model.User;
import com.anu.service.UserService;

	@RestController
	@RequestMapping("/admin")
	public class AdminController {

	    @Autowired
	    private UserService userService;

	    @PreAuthorize("hasRole('ADMIN')")
	    @GetMapping("/users")
	    public ResponseEntity<List<User>> getAllUsers() {
	        List<User> users = userService.findAll();
	        return new ResponseEntity<>(users, HttpStatus.OK);
	    }

    
}
