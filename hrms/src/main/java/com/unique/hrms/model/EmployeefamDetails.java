package com.unique.hrms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HRMS_EMP_FAMILY_DETAILS")
public class EmployeefamDetails {

	@Id
	@Column(name="ID")
	private int intId;
	
	@Column(name="FAM_MEM_NAME")
	private String strName;
	
	@Column(name="FAM_MEM_RELA")
	private String strRelation;
	
	@Column(name="FAM_MEM_GENDER")
	private String strGender;
	
	@Column(name="FAM_MEM_MOBILE")
	private String strContactNum;

	public int getIntId() {
		return intId;
	}

	public void setIntId(int intId) {
		this.intId = intId;
	}

	public String getStrName() {
		return strName;
	}

	public void setStrName(String strName) {
		this.strName = strName;
	}

	public String getStrRelation() {
		return strRelation;
	}

	public void setStrRelation(String strRelation) {
		this.strRelation = strRelation;
	}

	public String getStrGender() {
		return strGender;
	}

	public void setStrGender(String strGender) {
		this.strGender = strGender;
	}

	public String getStrContactNum() {
		return strContactNum;
	}

	public void setStrContactNum(String strContactNum) {
		this.strContactNum = strContactNum;
	}
	
}
