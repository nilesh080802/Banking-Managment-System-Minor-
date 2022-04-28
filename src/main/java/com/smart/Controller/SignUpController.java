package com.smart.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.smart.entity.SignupData;
import com.smart.model.SignupDAOimp;
import com.smart.entity.LoginData;

/**
 * Servlet implementation class SignUpController
 */
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	SignupDAOimp Sdimp = null;
    public SignUpController() {
        super();
        Sdimp = new SignupDAOimp();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String action= request.getParameter("action");
		switch(action) {
	
		case "Signup": SignupData(request,response);
		RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
		rd.forward(request, response);	
		break;
		
		case "Login": LoginData(request,response);
		
		case "Dashboard":Dashboard(request,response);
		
		break;
		}
          
		
	}
	
	private void LoginData(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String Uname =request.getParameter("uname");
		String Password =request.getParameter("pass");
		System.out.println("UserNAme"+Uname);
		
		LoginData Ldata = new LoginData();
		
		Ldata.setUname(Uname);
		Ldata.setPassword(Password);
		
		String Duname = Sdimp.checkLoginData(Ldata);
		
	
	//	System.out.println(Duname);
		if(Duname != null) {
			request.setAttribute("user", Duname);
			RequestDispatcher rd = request.getRequestDispatcher("indexnew.jsp");
			rd.forward(request, response);		
		}
		else
		{
			request.setAttribute("error", "Please enter valid details");
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);	
			
		}
	}

	protected void SignupData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String fname= request.getParameter("fname");
		String lname= request.getParameter("lname");
		String email= request.getParameter("email");
		String cnumber= request.getParameter("cnumber");
		String wnumber= request.getParameter("wnumber");
		String uid= request.getParameter("uid");
		String pass= request.getParameter("pass");
		String cpass= request.getParameter("cpass");
		
		
		SignupData Sdata = new SignupData();
		
		Sdata.setFname(fname);
		Sdata.setLname(lname);
		Sdata.setEmail(email);
		Sdata.setCnumber(cnumber);
		Sdata.setWnumber(wnumber);
		Sdata.setUid(uid);
		Sdata.setPass(pass);
		Sdata.setCpass(cpass);
		
		Sdimp.addSignupData(Sdata);
//		System.out.println(Sdata);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	protected void Dashboard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Uname =request.getParameter("uname");
		String Password =request.getParameter("pass");
		
		LoginData Ldata = new LoginData();
		
		Ldata.setUname(Uname);
		Ldata.setPassword(Password);
		
		String Duname = Sdimp.checkLoginData(Ldata);
		
		request.setAttribute("user", Duname);
		
	}
}



