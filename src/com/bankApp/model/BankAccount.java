package com.bankApp.model;

public class BankAccount {
	int initialBalance;
	String customerName;
	int acountNumber;
	static int nrAcounts=0;
	
	public BankAccount(int initialBalance, String customerName) {
		this.initialBalance = initialBalance;
		this.customerName = customerName;
		acountNumber=nrAcounts;
		nrAcounts++;
	}
	
	public BankAccount(int id, int initialBalance, String customerName) {
		this.initialBalance = initialBalance;
		this.customerName = customerName;
		acountNumber=id;
	}
	
	public int getInitialBalance() {
		return initialBalance;
	}

	public void setInitialBalance(int initialBalance) {
		this.initialBalance = initialBalance;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getAcountNumber() {
		return acountNumber;
	}

	public void setAcountNumber(int acountNumber) {
		this.acountNumber = acountNumber;
	}

	public static int getNrAcounts() {
		return nrAcounts;
	}

	public static void setNrAcounts(int nrAcounts) {
		BankAccount.nrAcounts = nrAcounts;
	}
	
}
