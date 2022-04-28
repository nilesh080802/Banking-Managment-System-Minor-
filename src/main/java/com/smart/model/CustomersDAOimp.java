package com.smart.model;

import java.sql.PreparedStatement;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.smart.entity.CustomersData;
import com.smart.utill.DBConnection;
import com.mysql.jdbc.Connection;
import com.smart.entity.LoginData;

public class CustomersDAOimp implements CustomersDAO {
	
	static Connection con=null;
	public CustomersDAOimp() {
		con=DBConnection.openConnection();
	}
	
	public Integer getAccountNUmber() {
			
		    int account=0;
		try {
			
			PreparedStatement ps = con.prepareStatement("Select * from smartaccount");
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()) {
			 	 account = rs.getInt("AccountNumber");
			 	 System.out.println(account);
			}
			PreparedStatement ps2 = con.prepareStatement("update smartaccount Set AccountNumber=?");
			ps2.setInt(1,(account+1));
			ps2.executeUpdate();
			System.out.println(account);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return account+1;
		
	}
		
	public ArrayList<CustomersData> getCustomerData()
	{
		ArrayList <CustomersData> customers=new ArrayList<>();
		try {
	
		String DQL ="select*from customers";
		PreparedStatement ps=con.prepareStatement(DQL);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			CustomersData cd=new CustomersData(); 
			cd.setFirstName(rs.getString("FirstName"));
			cd.setLastName(rs.getString("LastName"));
			cd.setEmail(rs.getString("Email"));
			cd.setAdharNumber(rs.getString("AdharNumber"));
			cd.setAddress(rs.getString("Address"));
			cd.setAccount(rs.getString("AccountNumber"));
			cd.setContactNumber(rs.getString("ContactNumber"));
			cd.setAmount(rs.getInt("Amount"));
			cd.setDateTime(rs.getString("DateTime"));
			
			customers.add(cd);
			
		}
		
		}catch(Exception e) {e.printStackTrace();}
		
		return customers;
	}
	public void addCustomersData(CustomersData sdata ) {
		
		try {
 			PreparedStatement ps=con.prepareStatement("insert into Customers(FirstName,LastName,Email,ContactNumber,AdharNumber,Address,DateTime,UserId,AccountNumber,Amount) values(?,?,?,?,?,?,?,?,?,?)");
 			
 			ps.setString(1,sdata.getFirstName());
 			ps.setString(2,sdata.getLastName());
 			ps.setString(3,sdata.getEmail());
 			ps.setString(4,sdata.getContactNumber());
 			ps.setString(5,sdata.getAdharNumber());
 			ps.setString(6,sdata.getAddress());
 			ps.setString(7,sdata.getDateTime());
 			ps.setString(8,sdata.getUserId());
 			ps.setString(9, sdata.getAccount());
 			ps.setInt(10,sdata.getAmount());
 		
 			ps.executeUpdate();
		
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		
	}
	
	
	
	

	
	
}
