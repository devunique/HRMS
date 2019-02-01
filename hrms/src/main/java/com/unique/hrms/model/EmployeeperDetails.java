package com.unique.hrms.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="HRMS_EMP_PERSONAL_DETAILS")
public class EmployeeperDetails {

	private int id;
	
	private String strOffEmail;
	
	private String strPerEmail;
	
	private String strMaritalStatus;
	
	private Date dtDOB;
	
	private long lngContactNo;
	
	private String strBloodGrp;
	
	private String strPanNumber;
	
	private String strPassport;

	public String getStrOffEmail() {
		return strOffEmail;
	}

	public void setStrOffEmail(String strOffEmail) {
		this.strOffEmail = strOffEmail;
	}

	public String getStrPerEmail() {
		return strPerEmail;
	}

	public void setStrPerEmail(String strPerEmail) {
		this.strPerEmail = strPerEmail;
	}

	public String getStrMaritalStatus() {
		return strMaritalStatus;
	}

	public void setStrMaritalStatus(String strMaritalStatus) {
		this.strMaritalStatus = strMaritalStatus;
	}

	public Date getDtDOB() {
		return dtDOB;
	}

	public void setDtDOB(Date dtDOB) {
		this.dtDOB = dtDOB;
	}

	public long getLngContactNo() {
		return lngContactNo;
	}

	public void setLngContactNo(long lngContactNo) {
		this.lngContactNo = lngContactNo;
	}

	public String getStrBloodGrp() {
		return strBloodGrp;
	}

	public void setStrBloodGrp(String strBloodGrp) {
		this.strBloodGrp = strBloodGrp;
	}

	public String getStrPanNumber() {
		return strPanNumber;
	}

	public void setStrPanNumber(String strPanNumber) {
		this.strPanNumber = strPanNumber;
	}

	public String getStrPassport() {
		return strPassport;
	}

	public void setStrPassport(String strPassport) {
		this.strPassport = strPassport;
	}
	
}
