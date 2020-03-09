package com.repo.dao;

public class AccountDao {
	private Integer accountNumber;
	private String accountType;
	private String branch;
	private Boolean salaryAccount;
	private Double initialDeposit;
	private Double currentBalance;
	private Integer userId;
	
	public Integer getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public Boolean getSalaryAccount() {
		return salaryAccount;
	}
	public void setSalaryAccount(Boolean salaryAccount) {
		this.salaryAccount = salaryAccount;
	}
	public Double getInitialDeposit() {
		return initialDeposit;
	}
	public void setInitialDeposit(Double initialDeposit) {
		this.initialDeposit = initialDeposit;
	}
	public Double getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(Double currentBalance) {
		this.currentBalance = currentBalance;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
