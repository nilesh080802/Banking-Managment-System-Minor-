package com.smart.utill;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DBConnection {
	private static String jdbcURL="jdbc:mysql://localhost:3306/hearme";
	private static String jdbcUsername ="root";
	private static String jdbcPassword ="";
	static Connection connection =null;
	
	
	public static Connection openConnection() {
		
		if(connection!=null) {
			
			return  connection;
		}
		else {
		      try {
			 Class.forName("com.mysql.jdbc.Driver");
			 connection =  (Connection) DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);	 
		 }catch(SQLException e){
			 e.printStackTrace();			 
		 } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }
		return  connection;
   }
}
