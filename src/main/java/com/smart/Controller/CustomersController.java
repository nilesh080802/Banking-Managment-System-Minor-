package com.smart.Controller;
import java.io.IOException;
import java.util.*;
import java.time.*;
import java.time.format.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smart.entity.CustomersData;
import com.smart.model.CustomersDAOimp;
public class CustomersController extends HttpServlet {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CustomersDAOimp Cdimp = null;
    public CustomersController() {
        super();
        Cdimp = new CustomersDAOimp();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{

			String act=request.getParameter("action");
			System.out.println(act);
			if(act.equals("cust"))
			{
				System.out.println(act);
				
				new CustomersController().getCustomersData(request, response);
			}
			
	

	}

	protected void doPost(HttpServletRequest request , HttpServletResponse response)
	{
	
	String userId="SmartPay01"; 
	int amount=100;
	String firstName= request.getParameter("fname");
	String lastName= request.getParameter("lname");
	String Email= request.getParameter("email");
	String contactNumber=request.getParameter("contactNumber");
	String adharNumber=request.getParameter("adharNumber");
	String address=request.getParameter("address");
	
	LocalDateTime dt=LocalDateTime.now();
	DateTimeFormatter df=DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
	
	String dateTime=df.format(dt);
	System.out.println(address);

	//System.out.println(name+"  "+mobile+"  "+bank+"  "+acc+"  "+con_acc+"  "+amount+"  "+dateTime+" "+type);

	try {

	CustomersData s=new CustomersData();

	s.setFirstName(firstName);
	s.setLastName(lastName);
	s.setEmail(Email);
	s.setContactNumber(contactNumber);
	s.setAdharNumber(adharNumber);
	s.setAddress(address);	
	s.setDateTime(dateTime);
	s.setUserId(userId);
	s.setAmount(amount);
	
	String account= (Cdimp.getAccountNUmber()).toString();
	s.setAccount(account);
	
	
	Cdimp.addCustomersData(s);
	
	RequestDispatcher rd = request.getRequestDispatcher("indexnew.jsp");
	rd.forward(request, response);
	
	}catch(Exception e) {
	System.out.println(e);
	}
	// doGet(request,responce);
	}
	
	public void getCustomersData(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		ArrayList<CustomersData> cust=null;
		
		
		cust=Cdimp.getCustomerData();
		request.setAttribute("customers",cust);
		
		RequestDispatcher rd = request.getRequestDispatcher("showCustomers.jsp");
		rd.forward(request, response);
		
		
	}
	

	

}
