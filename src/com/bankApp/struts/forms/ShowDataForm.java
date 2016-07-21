package com.bankApp.struts.forms;

import org.apache.struts.action.ActionForm;

public class ShowDataForm extends ActionForm{
	private String error;
	private String success;
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
}
