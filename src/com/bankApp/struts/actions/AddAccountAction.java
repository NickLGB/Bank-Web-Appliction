package com.bankApp.struts.actions;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.bankApp.model.Bank;
import com.bankApp.model.BankAccount;
import com.bankApp.sqlConn.mySqlConnector;
import com.bankApp.struts.forms.AddAccountForm;
import com.bankApp.struts.forms.DepositAccountForm;
import com.bankApp.struts.forms.ShowDataForm;
import com.bankApp.struts.forms.TransferAccountForm;
import com.bankApp.struts.forms.WithdrawAccountForm;
import com.mysql.jdbc.Connection;


public class AddAccountAction extends DispatchAction{
	
	public ActionForward addAccount(ActionMapping mapping, ActionForm form,
		    HttpServletRequest request, HttpServletResponse response)
		    throws Exception {
		
		AddAccountForm formBean = (AddAccountForm) form;

		
		String initialBalanceString= formBean.getInitialBalance();
		String costumerName = formBean.getCostumerName();
		

		// perform validation
		String mesajEroare="";
		if (initialBalanceString== null ) { 
			
			formBean.setError("Initial Balance filed null. Please complet it!");
			
		    return mapping.findForward("failure");
		}
		
		if (initialBalanceString== "" ) { 
			
			formBean.setError("Initial Balance filed null. Please complet it!");
			
		    return mapping.findForward("failure");
		}
		
		if (costumerName== null) {   
			formBean.setError("Costumer name filed null. Please complet it!");
			
		    return mapping.findForward("failure");
		}
		
		if (costumerName== "") {   
			formBean.setError("Costumer name filed null. Please complet it!");
			
		    return mapping.findForward("failure");
		}
		
		
		int initialBalance= Integer.parseInt(initialBalanceString);
		if (initialBalance<0 ) {   
			formBean.setError("Initial Balance must be greater than 0. Please complet it!");
			
		    return mapping.findForward("failure");
		}

		Connection conn=null;
		try {
			conn=mySqlConnector.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String clear="Select MAX(BA_ACCOUNT_NR) FROM ACCOUNTS";
		Statement st=conn.createStatement();
		ResultSet r=st.executeQuery(clear);
		
		r.next();
		int id=r.getInt(1);
		id++;

		BankAccount toInsert=new BankAccount(id,initialBalance,costumerName);
		
		
		String sql="INSERT INTO ACCOUNTS (BA_ACCOUNT_NR, BA_NAME, BA_AMOUNT) VALUES (?,?,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		
		ps.setInt(1, toInsert.getAcountNumber());
		ps.setString(2, toInsert.getCustomerName());
		ps.setInt(3, toInsert.getInitialBalance());
		
		ps.executeUpdate();
		
		ps.close();
		conn.close();
		
		
		formBean.setSuccess("Successfully added!");
		return mapping.findForward("success");  
	}
	
	public ActionForward depositAccount(ActionMapping mapping, ActionForm form,
		    HttpServletRequest request, HttpServletResponse response)
		    throws Exception {
		DepositAccountForm formBean = (DepositAccountForm) form;
		
		String accountNumberString= formBean.getAccountNumber();
		String amountString = formBean.getAmount();
		
		String mesajEroare="";
		if (accountNumberString== null ) { 
			
			formBean.setError("Account number empty!");
			
		    return mapping.findForward("failure");
		}
		
		if (amountString== null ) { 
			
			formBean.setError("Amount empty!");
			
		    return mapping.findForward("failure");
		}
		
		int accountNumber= Integer.parseInt(accountNumberString);
		int amount= Integer.parseInt(amountString);
		
		Bank b= new Bank();
		b.deposit(accountNumber, amount);
		
		formBean.setSuccess("Successfully deposited!");
		return mapping.findForward("success");  
	}
	
	public ActionForward withdrawAccount(ActionMapping mapping, ActionForm form,
		    HttpServletRequest request, HttpServletResponse response)
		    throws Exception {
		System.out.println("WithdrawAccount method \n");
		WithdrawAccountForm formBean = (WithdrawAccountForm) form;
		
		String accountNumberString= formBean.getAccountNumber();
		String amountString = formBean.getAmount();
		
		
		if (accountNumberString== null ) { 
			
			formBean.setError("Account number empty!");
			
		    return mapping.findForward("failure");
		}
		
		if (amountString== null ) { 
			
			formBean.setError("Amount empty!");
			
		    return mapping.findForward("failure");
		}
		
		int accountNumber= Integer.parseInt(accountNumberString);
		int amount= Integer.parseInt(amountString);
		
		Bank b= new Bank();
		b.withdraw(accountNumber, amount);
		
		formBean.setSuccess("Successfully deposited!");
		return mapping.findForward("success");  
	}
	
	public ActionForward transferAccount(ActionMapping mapping, ActionForm form,
		    HttpServletRequest request, HttpServletResponse response)
		    throws Exception {
		System.out.println("WithdrawAccount method \n");
		TransferAccountForm formBean = (TransferAccountForm) form;
		
		String toString= formBean.getTo();
		String fromString= formBean.getFrom();
		String amountString = formBean.getAmount();
		
		
		if (toString== null ) { 
			
			formBean.setError("Must be a destination account number");
			
		    return mapping.findForward("failure");
		}
		
		if (fromString== null ) { 
			
			formBean.setError("Must be account number from wich to transfer!");
			
		    return mapping.findForward("failure");
		}
		
		if (amountString== null ) { 
			
			formBean.setError("Amount empty!");
			
		    return mapping.findForward("failure");
		}
		
		int to= Integer.parseInt(toString);
		int from= Integer.parseInt(fromString);
		int amount= Integer.parseInt(amountString);
		
		Bank b= new Bank();
		b.transfer(from, to, amount);
		
		formBean.setSuccess("Successfully deposited!");
		return mapping.findForward("success");  
	}
	
	public ActionForward showDataAcounts(ActionMapping mapping, ActionForm form,
		    HttpServletRequest request, HttpServletResponse response)
		    throws Exception {
		System.out.println("Show Data method \n");
		ShowDataForm formBean = (ShowDataForm) form;
		
		Connection conn=null;
		try {
			conn=mySqlConnector.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String clear="Select * FROM ACCOUNTS";
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery(clear);
		
		List<BankAccount> accounts=new ArrayList<BankAccount>();
		
		while(rs.next()){
			
			int id=rs.getInt(1);
			int initialBalance=rs.getInt(3);
			String customerName=rs.getString(2);
			accounts.add(new BankAccount(id,initialBalance,customerName));
		}
		
		request.setAttribute("accounts", accounts);
		
		RequestDispatcher reqDispatcher = request.getRequestDispatcher("/pages/add.jsp");
        reqDispatcher.forward(request,response);     
		
		rs.close();
		conn.close();
			
		formBean.setSuccess("Successfully deposited!");
		return mapping.findForward("success");  
	}
	
}
