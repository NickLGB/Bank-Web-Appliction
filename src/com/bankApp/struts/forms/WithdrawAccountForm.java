package com.bankApp.struts.forms;

import org.apache.struts.action.ActionForm;

public class WithdrawAccountForm extends ActionForm{

	private String accountNumber;
	private String amount;
	private String error;
	private String success;
	
	
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String succes) {
		this.success = succes;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	public String getError() {
		return error;
	}
	public void setError(String mes) 
	{
	    this.error =
	        "<span style='color:red'>" + mes + "</span>";
	}
	
}
