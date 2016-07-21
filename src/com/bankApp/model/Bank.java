package com.bankApp.model;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bankApp.sqlConn.mySqlConnector;
import com.bankApp.sqlConn.sqlConnector;
import com.mysql.jdbc.Connection;

public class Bank {
	ArrayList<BankAccount> acounts;


	public Bank() {
		acounts=new ArrayList<BankAccount>();
	}

	public void deposit(int accountNumber, int amount) throws SQLException{

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

		String getIn="SELECT BA_AMOUNT FROM ACCOUNTS WHERE BA_ACCOUNT_NR=" + accountNumber;
		Statement s=conn.createStatement();
		ResultSet r=s.executeQuery(getIn);

		r.next();
		int initialBalance=r.getInt(1);

		String sql="UPDATE ACCOUNTS SET BA_AMOUNT=? WHERE BA_ACCOUNT_NR=?";
		PreparedStatement st=conn.prepareStatement(sql);

		st.setInt(1, initialBalance+amount);
		st.setInt(2, accountNumber);
		st.executeUpdate();

		st.close();
		conn.close();
	}

	public void withdraw(int accountNumber, int amount) throws SQLException{


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
		
		String getIn="SELECT BA_AMOUNT FROM ACCOUNTS WHERE BA_ACCOUNT_NR=" + accountNumber;
		Statement s=conn.createStatement();
		ResultSet r=s.executeQuery(getIn);

		r.next();
		int initialBalance=r.getInt(1);
		
		String sql="UPDATE ACCOUNTS SET BA_AMOUNT=? WHERE BA_ACCOUNT_NR=?";
		PreparedStatement st=conn.prepareStatement(sql);
		
		st.setInt(1, initialBalance-amount);
		st.setInt(2, accountNumber);
		st.executeUpdate();

		st.close();
		conn.close();


	}

	public int getBalance(int accountNumber){
		return acounts.get(accountNumber-1).getInitialBalance();
	}

	public boolean transfer(int from,int to, int amount) throws SQLException{

		this.withdraw(from, amount);
		this.deposit(to, amount);

		return true;
	}

	public void addAccount(int initialBalance, String costumerName) throws SQLException {
		// TODO Auto-generated method stub


	}

	public void showDB() throws SQLException{
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

		String cmd = "Select * from ACCOUNTS";
		Statement st=conn.createStatement();

		ResultSet rs=st.executeQuery(cmd);

		while(rs.next()){
			System.out.println(rs.getInt(1) + " " + rs.getString(2)+ " " + rs.getInt(3));
		}
		rs.close();
		conn.close();	
	}
}
