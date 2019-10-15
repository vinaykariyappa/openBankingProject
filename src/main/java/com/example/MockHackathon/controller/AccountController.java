package com.example.MockHackathon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MockHackathon.adapter.ObpApiClient;
import com.example.MockHackathon.model.Account;
import com.example.MockHackathon.model.AccountViews;
import com.example.MockHackathon.model.User;

@RestController
@RequestMapping("/service")
public class AccountController {

	@Autowired
	private ObpApiClient ObpApiClient;

	@GetMapping("/users/current")
	public ResponseEntity<User> getCurrentUser() {
		User user = ObpApiClient.getCurrentUser();
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@PostMapping("/createAccount/{bankId}/accounts/{accountId}")
	public ResponseEntity<Account> createAccount(@RequestBody Account acocunt, @PathVariable("bankId") String bankId,
			@PathVariable("accountId") String accountId) {
		Account accountfi = ObpApiClient.createAccount(bankId, accountId, acocunt);
		return new ResponseEntity<Account>(accountfi,HttpStatus.OK);
	}
	
	@GetMapping("/viewAccount/{bankId}/accounts/{accountId}/views")
	public ResponseEntity<AccountViews> viewAccount(@PathVariable("bankId") String bankId,
			@PathVariable("accountId") String accountId) {
		AccountViews accountfi = ObpApiClient.getViewsForAccount(bankId, accountId);
		return new ResponseEntity<AccountViews>(accountfi,HttpStatus.OK);
	}
	
}
