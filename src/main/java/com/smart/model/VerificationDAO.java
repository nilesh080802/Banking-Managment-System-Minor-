package com.smart.model;

public interface VerificationDAO {

	public boolean verifyAccount(String firstName,String AccountNumber);
	
	public Integer verifyAmountForWithdraw(String Account,Integer amount);
	
	public Integer verifyAmountForSendMoney(Integer amount);
	
}
