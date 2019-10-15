package com.example.MockHackathon.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Account {

	@JsonProperty("user_id")
	private String userId;

	private String label;

	@JsonProperty("bank_id")
	private String bankId;

	@JsonProperty("branch_id")
	private String branchId;

	@JsonProperty("balance")
	private MoneyJson balance;

	private String type;

	@JsonProperty("account_routing")
	private AccountRouting accountRouting;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public MoneyJson getBalance() {
		return balance;
	}

	public void setBalance(MoneyJson balance) {
		this.balance = balance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public AccountRouting getAccountRouting() {
		return accountRouting;
	}

	public void setAccountRouting(AccountRouting accountRouting) {
		this.accountRouting = accountRouting;
	}

}
