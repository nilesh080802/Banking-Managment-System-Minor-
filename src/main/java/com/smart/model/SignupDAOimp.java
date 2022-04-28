package com.smart.model;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.smart.entity.SignupData;
import com.smart.utill.DBConnection;
import com.mysql.jdbc.Connection;
import com.smart.entity.LoginData;

public class SignupDAOimp implements SignupDAO {
	
	static Connection con=null;
	public SignupDAOimp() {
		con=DBConnection.openConnection();
	}
	
	
		
	public void addSignupData(SignupData sdata ) {
		
		try {
 			PreparedStatement ps=con.prepareStatement("insert into SignUpData(Fname,Lname,Email,Cnumber,Wnumber,Uid,Pass,Cpass) values(?,?,?,?,?,?,?,?)");
 			
 			ps.setString(1,sdata.getFname());
 			ps.setString(2,sdata.getLname());
 			ps.setString(3,sdata.getEmail());
 			ps.setString(4,sdata.getCnumber());
 			ps.setString(5,sdata.getWnumber());
 			ps.setString(6,sdata.getUid());
 			ps.setString(7,sdata.getPass());
 			ps.setString(8,sdata.getCpass());
 			
 		
 			ps.executeUpdate();
		
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		
	}
	
	public String checkLoginData(LoginData ldata)  {
		
		    String userName=null;
		
			PreparedStatement ps;
			try {
				
				ps = con.prepareStatement("Select * from signupdata Where Email=? OR Uid=? AND Cpass=?");
				
				
				
				ps.setString(1, ldata.getUname());
				ps.setString(2, ldata.getUname());
				ps.setString(3, ldata.getPassword());
				
				ResultSet rs= ps.executeQuery();
				
				if(rs.next()) {
					
				    userName=rs.getString("Uid");
				    //System.out.println(userName);
				}
			
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return userName ;
			
		
		
	}
	
	

	
	
}
