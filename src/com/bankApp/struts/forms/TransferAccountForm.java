package com.bankApp.struts.forms;

import org.apache.struts.action.ActionForm;

public class TransferAccountForm extends ActionForm{

	private String to;
	private String from;
	private String amount;
	private String error;
	private String success;
	
	
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String succes) {
		this.success = succes;
	}

	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
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
