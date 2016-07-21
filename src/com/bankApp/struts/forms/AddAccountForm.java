package com.bankApp.struts.forms;

import org.apache.struts.action.ActionForm;

public class AddAccountForm extends ActionForm {
	
	private String accountNumber;
	private String initialBalance;
	private String costumerName;
	private String error;
	private String success;
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getError() {
		return error;
	}
	public String getInitialBalance() {
		return initialBalance;
	}
	public void setInitialBalance(String initialBalance) {
		this.initialBalance = initialBalance;
	}
	public String getCostumerName() {
		return costumerName;
	}
	public void setCostumerName(String costumerName) {
		this.costumerName = costumerName;
	}
	
	public void setError(String mes) 
	{
	    this.error =
	        "<span style='red'>" + mes + "</span>";
	}
	
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String mes) {
		this.success = mes ;
	}
	
	
}
