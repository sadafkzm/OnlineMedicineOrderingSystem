package com.anu;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.anu.dao.UserDao;
import com.anu.exception.UserFoundException;
import com.anu.model.Role;
import com.anu.model.User;
import com.anu.model.UserDto;
import com.anu.service.RoleService;
import com.anu.service.UserService;



@SpringBootApplication
public class OnlineMedicineOderingSystem  {

   

    
	public static void main(String[] args) {
		SpringApplication.run(OnlineMedicineOderingSystem.class, args);
		System.out.println("Applocation Started.......");
	}
	 
	       
	        
	        

	       

}

