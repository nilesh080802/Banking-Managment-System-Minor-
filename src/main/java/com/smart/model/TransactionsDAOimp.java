package com.smart.model;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.smart.entity.TransactionsData;
import com.smart.utill.DBConnection;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class TransactionsDAOimp implements TransactionsDAO{

	static Connection con=null;
	public TransactionsDAOimp() {
		con = DBConnection.openConnection();
	}
	
	
	public  ArrayList<TransactionsData> get(){
		ArrayList<TransactionsData> transactions = new ArrayList<TransactionsData>();
		
		String dql="Select * from transactions";
	try {
		PreparedStatement ps= (PreparedStatement) con.prepareStatement(dql);
		
		ResultSet rs= ps.executeQuery();
		
		while(rs.next()){
			TransactionsData td = new TransactionsData();
			
			String fname=rs.getString("FirstName");
			String lname=rs.getString("LastName");
			String mobileNumber=rs.getString("MobileNumber");
			String accountNumber=rs.getString("AccountNumber");
			int amount=rs.getInt("Amount");
			String creditTo=rs.getString("CreditedTo");
			String debitTo=rs.getString("DebitedTo");
			String dateTime=rs.getString("DateTime");
			
			
			td.setFirstName(fname);
			td.setLastName(lname);
			td.setMobileNumber(mobileNumber);
			td.setAccountNumber(accountNumber);
			td.setAmount(amount);
			td.setCredit(creditTo);
			td.setDebit(debitTo);
			td.setDateTime(dateTime);
			
			
			transactions.add(td);
		}
		
	}catch(Exception e) {
		System.out.println(e);
	}
		
		
	return null;
		
	}
	
	public void addTransactionsData( TransactionsData td) {
		String dml="insert into transactions values(?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(dml);
			ps.setString(1, td.getFirstName());
			ps.setString(2, td.getLastName());
			ps.setString(3, td.getMobileNumber());
			ps.setString(4, td.getAccountNumber());
			ps.setString(5,td.getConAccountNumber());
			ps.setInt(6, td.getAmount());
			ps.setString(7,td.getCredit());
			ps.setString(8, td.getDebit());
			ps.setString(9, td.getDateTime());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		
	}
}
