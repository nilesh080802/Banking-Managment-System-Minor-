package com.smart.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.smart.utill.DBConnection;
import com.mysql.jdbc.PreparedStatement;
import com.smart.model.*;

public class Verification implements VerificationDAO{
	
	static Connection con=null;
	public Verification() {
		
		con=DBConnection.openConnection();
	}
	
	public boolean verifyAccount(String fname,String Account)  {
		
		try {
			PreparedStatement ps = (PreparedStatement)con.prepareStatement("Select * from customers where AccountNumber =? AND FirstName=?");
			ps.setString(1, Account);
			ps.setString(2, fname);
			ResultSet rs = ps.executeQuery();
			
			
			if(rs.next()) {
				System.out.println(rs.getString("ContactNumber"));
				return true;
				
			}
			return false;
			
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return false;
	}
	public Integer verifyAmountForWithdraw(String Account,Integer amount) {
			try {
		
				PreparedStatement ps = (PreparedStatement)con.prepareStatement("Select Amount from customers where AccountNumber =?");
				ps.setString(1, Account);
				ResultSet rs = ps.executeQuery();
				rs.next();
				int amnt=rs.getInt("amount");
				
				if(amount<=amnt) {
					return amnt;
				}
				return 0;
				
				} catch (Exception e) {
					e.printStackTrace();// TODO: handle exception
				}
		
		
		
		return 0;
	}
	
	public void updateAmountForWithdraw(int amount,String accNum,Integer jspAmount) {
		
		try {
			PreparedStatement ps2 = (PreparedStatement)con.prepareStatement("Update  customers set Amount=? where AccountNumber=?");
			ps2.setInt(1, amount);
			ps2.setString(2, accNum);
			 ps2.executeUpdate();
			
			PreparedStatement ps = (PreparedStatement)con.prepareStatement("Select Amount from smartaccount");
			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			int amnt=rs.getInt("Amount");
			
			jspAmount+=amnt;
			PreparedStatement ps3 = (PreparedStatement)con.prepareStatement("Update smartaccount set Amount=?");
			ps3.setInt(1, jspAmount);
			 ps3.executeUpdate();
			
			
				
			 
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	public Integer verifyAmountForSendMoney( Integer amount) {
		
		Integer Amount =null;
		try {
			PreparedStatement ps = (PreparedStatement)con.prepareStatement("Select Amount from smartaccount");
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				Amount =rs.getInt("Amount");
				
				if(amount<=Amount) {
					
					return Amount;
				}
			
					return 0;
	
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
		
	}
	
	public void updateAmountForSendMoney(Integer amount,String accNum,Integer jspAmount) {
		
		try {
			PreparedStatement ps = (PreparedStatement)con.prepareStatement("Update smartaccount set Amount=?");
			ps.setInt(1, amount);
			 ps.executeUpdate();
			
			 PreparedStatement ps1 = (PreparedStatement)con.prepareStatement("Select Amount from customers where AccountNumber=?");
				ps1.setString(1, accNum);
				ResultSet rs = ps1.executeQuery();
				
				rs.next();
				int amnt=rs.getInt("Amount");
				
				jspAmount+=amnt;
				
				PreparedStatement ps2 = (PreparedStatement)con.prepareStatement("Update  customers set Amount=? where AccountNumber=?");
				ps2.setInt(1, jspAmount);
				ps2.setString(2, accNum);
				ps2.executeUpdate();
			 
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	
	

	

}
