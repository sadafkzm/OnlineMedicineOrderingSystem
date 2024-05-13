package com.anu.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.anu.dao.UserDao;
import com.anu.exception.MedicineNotFoundException;
import com.anu.exception.UserNotFoundException;
import com.anu.model.Role;
import com.anu.model.User;
import com.anu.model.UserDto;
import com.anu.service.RoleService;
import com.anu.service.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    public UserDetails loadUserByUsername(String username) throws UserNotFoundException {
        Optional<User> user = userDao.findByUsername(username);
        User user1 = user.orElse(new User());
        if(user == null){
            throw new UserNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user1.getUsername(), user1.getPassword(), getAuthority(user1));
    }

    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        });
        return authorities;
    }

    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        userDao.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public User findOne(String username) {
    	
    	
        return userDao.findByUsername(username)
        		.orElseThrow(()-> new UserNotFoundException("User not found"));
    }

   

   
    
    
    @Override
    public User save(UserDto user) {

    	Role role;
		Set<Role> roleSet = new HashSet<>();
        User nUser = user.getUserFromDto();
        nUser.setPassword(bcryptEncoder.encode(user.getPassword()));

        
        if(nUser.getEmail().equals("sdfkzm786@gmail.com")){
            role = roleService.findByName("ADMIN");
            roleSet.add(role);
        }
            else
            {
            role=	roleService.findByName("USER");
            
            roleSet.add(role);	
        }
    
        nUser.setRoles(roleSet);
        return userDao.save(nUser);
    }
}
