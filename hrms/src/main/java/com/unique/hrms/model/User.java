package com.unique.hrms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name="HRMS_EMP_LOGIN_INFO")
public class User {

	@javax.persistence.Id
	@Column(name="EMP_ID",nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@Column(name="EMP_FST_NAME")
	private String strFstname;
	
	@Column(name="UserName")
	private String userName;
	
	@Column(name="Password")
	private String password;
	
	@Column(name="EMP_LST_NAME")
	private String strLstname;
	
	@Column(name="EMP_EMAIL_ADD")
	private String strEmail;

	@Column(name="SYS_PSW_RESET_TKN")
	private String strResetToken;
	
	public String getResetToken() {
		return strResetToken;
	}

	public void setResetToken(String resetToken) {
		this.strResetToken = resetToken;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getStrFstname() {
		return strFstname;
	}

	public void setStrFstname(String strFstname) {
		this.strFstname = strFstname;
	}

	public String getStrLstname() {
		return strLstname;
	}

	public void setStrLstname(String strLstname) {
		this.strLstname = strLstname;
	}

	public String getStrEmail() {
		return strEmail;
	}

	public void setStrEmail(String strEmail) {
		this.strEmail = strEmail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

	
}
