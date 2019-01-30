package com.unique.hrms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="HRMS_EMPLOYEE_INFO")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value= {"dtCreatedAt","dtModifiedAt"})
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Emp_Id;

	@Column(name="EMP_FST_NAME")
	private String strFst_Name;
	
	@Column(name="EMP_LST_NAME")
	private String strLst_Name;
	
	@Column(name="EMP_DOB")
	private Date dtDOB;
	
	@Column(name="EMP_FATHER_NAME")
	private String strFatName;

	@Column(name="EMP_CREA_DATE",nullable=false,updatable=false)
	@Temporal(TemporalType.DATE)
	@CreatedDate
	private Date dtCreatedAt;
	
	@Column(name="EMP_MODI_DATE",nullable=false)
	@Temporal(TemporalType.DATE)
	@LastModifiedDate
	private Date dtModifiedAt;
	
	
	public Long getEmp_Id() {
		return Emp_Id;
	}

	public void setEmp_Id(Long emp_Id) {
		Emp_Id = emp_Id;
	}

	public Date getDtCreatedAt() {
		return dtCreatedAt;
	}

	public void setDtCreatedAt(Date dtCreatedAt) {
		this.dtCreatedAt = dtCreatedAt;
	}

	public Date getDtModifiedAt() {
		return dtModifiedAt;
	}

	public void setDtModifiedAt(Date dtModifiedAt) {
		this.dtModifiedAt = dtModifiedAt;
	}

	public String getStrFst_Name() {
		return strFst_Name;
	}

	public void setStrFst_Name(String strFst_Name) {
		this.strFst_Name = strFst_Name;
	}

	public String getStrLst_Name() {
		return strLst_Name;
	}

	public void setStrLst_Name(String strLst_Name) {
		this.strLst_Name = strLst_Name;
	}

	public Date getDtDOB() {
		return dtDOB;
	}

	public void setDtDOB(Date dtDOB) {
		this.dtDOB = dtDOB;
	}

	public String getStrFatName() {
		return strFatName;
	}

	public void setStrFatName(String strFatName) {
		this.strFatName = strFatName;
	}
	
	
}
