package com.smart.Controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.smart.entity.*;
import com.smart.model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class TransactionsController
 */
public class TransactionsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	TransactionsDAOimp tdi =null;
    public TransactionsController() {
    	tdi= new TransactionsDAOimp();
       
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		
		String credit = null;
		String debit = null;

		TransactionsData td = new TransactionsData();
		switch(action) {
		case "sendMoney":
			System.out.println(action);
			credit=request.getParameter("conAccountNumber");
			debit="SmartPay01";
			td.setCredit(credit);
			td.setDebit(debit);
			 
			doPost(request,response,td,action);
		
			break;
		case "withdraw":
			System.out.println(action);
			debit=request.getParameter("conAccountNumber");
			credit="SmartPay01";
			td.setCredit(credit);
			td.setDebit(debit);
			
			doPost(request,response,td,action);
			
			break;
		case "transactions": transactionList(request,response);
		
		
		break;
		default :break;
			
		}
		
		
		
		
	
	}

	private void transactionList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<TransactionsData> transactions =tdi.get();
//		System.out.println(transactions);
		request.setAttribute("transactions", transactions);
		RequestDispatcher rd = request.getRequestDispatcher("Transections.jsp");
		rd.forward(request, response);
//		System.out.println("forword to jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response,TransactionsData td,String action) throws ServletException, IOException {
		
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String mobileNumber=request.getParameter("mobileNumber");
		//String bankName=request.getParameter("bankName");
		String accountNumber=request.getParameter("accountNumber");
		String conAccountNumber=request.getParameter("conAccountNumber");
		
		int amount = Integer.parseInt(request.getParameter("amount")); 
		
		
		LocalDateTime dt=LocalDateTime.now();
		DateTimeFormatter df=DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
		
		String dateTime =df.format(dt);
		
		try {
		td.setFirstName(fname);
		td.setLastName(lname);
		td.setMobileNumber(mobileNumber);
		
		td.setConAccountNumber(conAccountNumber);
		td.setAccountNumber(accountNumber);
		td.setAmount(amount);
		td.setDateTime(dateTime);
		
//		System.out.println(action);
//		System.out.println(fname+"  "+accountNumber);
		if(new Verification().verifyAccount(fname,accountNumber)) {
		
			
			int Amount=0;
			
			switch(action) {
				case "sendMoney":
									//System.out.println(action+" "+new Verification().verifyAmountForSendMoney(amount));
									
									if((Amount=new Verification().verifyAmountForSendMoney(amount)) !=0) {
											
										Amount-=amount;
									
										new Verification().updateAmountForSendMoney(Amount,accountNumber,amount);
											
										tdi.addTransactionsData(td);
//										System.out.println("Transections data succsesfully called");
										request.setAttribute("amount", Amount);
										RequestDispatcher rd = request.getRequestDispatcher("sendMoney.jsp");
										rd.forward(request, response);
								}else {
									request.setAttribute("error", "Amount not sufficient");
									RequestDispatcher rd = request.getRequestDispatcher("sendMoney.jsp");
									rd.forward(request, response);
								}
				
				break;
				
				case "withdraw": if((Amount= new Verification().verifyAmountForWithdraw(conAccountNumber, amount))!=0) {
					
									Amount-=amount;
									new Verification().updateAmountForWithdraw(Amount,accountNumber,amount);
									tdi.addTransactionsData(td);
//									System.out.println("Transections data succsesfull called");
									RequestDispatcher rd = request.getRequestDispatcher("withdraw.jsp");
									rd.forward(request, response);
								}else {
									request.setAttribute("error", "Amount not sufficient");
									RequestDispatcher rd = request.getRequestDispatcher("withdraw.jsp");
									rd.forward(request, response);
								}
				
				break;
				
				default : System.out.println("Insufficient Balance");
			}
			
		}else {
			request.setAttribute("error", "Invalid Account!!!!");
			
			//System.out.println(action+"sendMoney");
			switch(action) {
			case "sendMoney":
				System.out.println(action);
				RequestDispatcher rd = request.getRequestDispatcher("sendMoney.jsp");
				rd.forward(request, response);break;
			
			case "withdraw":
				RequestDispatcher rd1 = request.getRequestDispatcher("withdraw.jsp");
				rd1.forward(request, response);break;
			default :
				
				RequestDispatcher rd2 = request.getRequestDispatcher("indexnew.jsp");
				rd2.forward(request, response);break;
			}
			
	
		}
		
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
}
