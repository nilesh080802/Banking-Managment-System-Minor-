package com.smart.model;

import com.smart.entity.LoginData;
import com.smart.entity.SignupData;

public interface SignupDAO {
	 void addSignupData(SignupData sdata );
	 String checkLoginData(LoginData ldata); 
	 //int sendMoney();
	 
}
