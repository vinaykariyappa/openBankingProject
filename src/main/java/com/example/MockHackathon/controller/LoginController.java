package com.example.MockHackathon.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MockHackathon.adapter.DirectAuthentication;
import com.example.MockHackathon.model.User;

@RestController
@RequestMapping("/service")
public class LoginController {

	@Autowired
	private DirectAuthentication directAuthentication;
	
	@Autowired
	private HashMap<String,String> map;
	
	@Value("${obp.consumerKey}")
	private String consumerKey;
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody User user) {
		String token = directAuthentication.login(user.getUserName(),user.getPassword(),consumerKey);
		map.put("TOKEN", token);
		return new ResponseEntity<String>(token,HttpStatus.OK);
	}
	
}
