package com.example.stu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.stu.entity.IdPass;
import com.example.stu.jwt.CustomUserDetails;
import com.example.stu.jwt.JwtUtil;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ApplicationContainer {
	
	@Autowired CustomUserDetails cu;
	@Autowired JwtUtil jwt;
	@Autowired DaoAuthenticationProvider dao;
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody IdPass id)
	{
		try
		{
			this.dao.authenticate((new UsernamePasswordAuthenticationToken(id.getUsername(), id.getPassword())));
			
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		UserDetails usedDetals=this.cu.loadUserByUsername(id.getUsername());
		
		return ResponseEntity.ok(jwt.generateToken(usedDetals));
	}

}
