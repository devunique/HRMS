package com.unique.hrms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HRMS_EMP_BASIC_DETAILS")
public class EmployeebasicDetails {

	@Id
	@Column(name="I_EMP_ID", nullable=false, updatable=false)
	private int intEmpID;
	
	@Column(name="I_Title")
	private String strTitle;
	
	@Column(name="I_FIRST_NAME")
	private String strFirstName;
	
	@Column(name="I_MIDDLE_NAME")
	private String strMiddleName;
	
	@Column(name="I_LAST_NAME")
	private String strLastName;
	
	@Column(name="I_DESIG")
	private String strDesignation;
	
	@Column(name="I_DOJ")
	private Date dtDOJ;

	public int getIntEmpID() {
		return intEmpID;
	}

	public void setIntEmpID(int intEmpID) {
		this.intEmpID = intEmpID;
	}

	public String getStrTitle() {
		return strTitle;
	}

	public void setStrTitle(String strTitle) {
		this.strTitle = strTitle;
	}

	public String getStrFirstName() {
		return strFirstName;
	}

	public void setStrFirstName(String strFirstName) {
		this.strFirstName = strFirstName;
	}

	public String getStrMiddleName() {
		return strMiddleName;
	}

	public void setStrMiddleName(String strMiddleName) {
		this.strMiddleName = strMiddleName;
	}

	public String getStrLastName() {
		return strLastName;
	}

	public void setStrLastName(String strLastName) {
		this.strLastName = strLastName;
	}

	public String getStrDesignation() {
		return strDesignation;
	}

	public void setStrDesignation(String strDesignation) {
		this.strDesignation = strDesignation;
	}
	
}
