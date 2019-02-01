package com.unique.hrms.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HRMS_LOGIN_INFO")
public class UserLogin {
	
	@Column(name="I_LOGIN_ID",nullable = false, updatable = false)
	@Id
	private String strLoginId;
	
	@Column(name="I_PASSWORD")
	private String strPassword;
	
	@Column(name="I_EMP_ID")
	private String strEmpId;
	

	@Column(name="S_LAST_LOGIN")
	private Date dtLastLogin;
	
	
	@Column(name="S_ISLOGIN") // value should be T or F
	private char chrIsLogin;
	
	
	@Column(name="S_RESET_PASS") // value should be T or F
	private char chrResetPass;
	
	
	@Column(name="S_RETRY_COUNT") 
	private int intRetryCount;
	
	
	@Column(name="S_ISLOCKED") // value should be T or F
	private char chrIsLocked;
	
	
	@Column(name="S_USER_TYPE") 
	private char chrUserType;
	
	@Column(name="S_FIRST_LOGIN") //value Should be T or F
	private char chrFirstLogin;
	
	@Column(name ="C_RESET_TOKEN") //Random number generation
	private String strResetToken;

	public String getStrLoginId() {
		return strLoginId;
	}

	public void setStrLoginId(String strLoginId) {
		this.strLoginId = strLoginId;
	}

	public String getStrPassword() {
		return strPassword;
	}

	public void setStrPassword(String strPassword) {
		this.strPassword = strPassword;
	}

	public String getStrEmpId() {
		return strEmpId;
	}

	public void setStrEmpId(String strEmpId) {
		this.strEmpId = strEmpId;
	}

	public Date getDtLastLogin() {
		return dtLastLogin;
	}

	public void setDtLastLogin(Date dtLastLogin) {
		this.dtLastLogin = dtLastLogin;
	}

	public char getChrIsLogin() {
		return chrIsLogin;
	}

	public void setChrIsLogin(char chrIsLogin) {
		this.chrIsLogin = chrIsLogin;
	}

	public char getChrResetPass() {
		return chrResetPass;
	}

	public void setChrResetPass(char chrResetPass) {
		this.chrResetPass = chrResetPass;
	}

	public int getIntRetryCount() {
		return intRetryCount;
	}

	public void setIntRetryCount(int intRetryCount) {
		this.intRetryCount = intRetryCount;
	}

	public char getChrIsLocked() {
		return chrIsLocked;
	}

	public void setChrIsLocked(char chrIsLocked) {
		this.chrIsLocked = chrIsLocked;
	}

	public char getChrUserType() {
		return chrUserType;
	}

	public void setChrUserType(char chrUserType) {
		this.chrUserType = chrUserType;
	}

	public char getChrFirstLogin() {
		return chrFirstLogin;
	}

	public void setChrFirstLogin(char chrFirstLogin) {
		this.chrFirstLogin = chrFirstLogin;
	}

	public String getStrResetToken() {
		return strResetToken;
	}

	public void setStrResetToken(String strResetToken) {
		this.strResetToken = strResetToken;
	}
}
