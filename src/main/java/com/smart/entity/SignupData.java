package com.smart.entity;

public class SignupData {
	private String Fname;
	private String Lname;
	private String Email;
	private String Cnumber;
	private String Wnumber;
	private String Uid;
	private String Pass;
	private String Cpass;
	//For Login----------------------
	
    //-------------------------------
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	@Override
	public String toString() {
		return "SignupData [Fname=" + Fname + ", Lname=" + Lname + ", Email=" + Email + ", Cnumber=" + Cnumber
				+ ", Wnumber=" + Wnumber + ", Uid=" + Uid + ", Pass=" + Pass + ", Cpass=" + Cpass + "]";
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getCnumber() {
		return Cnumber;
	}
	public void setCnumber(String cnumber) {
		Cnumber = cnumber;
	}
	public String getWnumber() {
		return Wnumber;
	}
	public void setWnumber(String wnumber) {
		Wnumber = wnumber;
	}
	public String getUid() {
		return Uid;
	}
	public void setUid(String uid) {
		Uid = uid;
	}
	public String getPass() {
		return Pass;
	}
	public void setPass(String pass) {
		Pass = pass;
	}
	public String getCpass() {
		return Cpass;
	}
	public void setCpass(String cpass) {
		Cpass = cpass;
	}
	
	
	

}
