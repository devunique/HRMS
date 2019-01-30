package com.unique.hrms.model;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import com.unique.hrms.util.AppUtil;

@Entity
@Table(name="HRMS_EMAIL_AUDIT")
public class Email {

	@javax.persistence.Id
	@Column(name="EMAIL_AUDIT_ID",nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@Column(name="FROM_EMAIL")
	private String strFrom;
    
	@Column(name="TO_EMAIL")
	@ElementCollection(targetClass=String.class)
	private List<String> toList;
	
	@Column(name="CC_LIST")
	@ElementCollection(targetClass=String.class)
	private List<String> ccList;
	
	@Column(name="MAIL_SUBJ")
	private String strSubject;
	
	@Column(name="MAIL_CONTENT")
	private String strMessage;
	
	@Column(name="IS_HTML_TYPE")
	private boolean isHtml;
	
	@Column(name="CREA_DATE")
	private Date dtCreatedDate;
	
	/* Mail status fields value will be F and S
	 * F-Fail
	 * S-Success
	 * */
	@Column(name="MAIL_STATUS")
	private char strMailStatus;
	
	@Column(name="ERROR_MESSAGE")
	private String strErrMessage;
	
	public String getStrErr() {
		return strErrMessage;
	}

	public void setStrErr(String strErr) {
		this.strErrMessage = strErr;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Date getDtCreatedDate() {
		return dtCreatedDate;
	}

	public void setDtCreatedDate(Date dtCreatedDate) {
		this.dtCreatedDate = dtCreatedDate;
	}

	public char getStrMailStatus() {
		return strMailStatus;
	}

	public void setStrMailStatus(char strMailStatus) {
		this.strMailStatus = strMailStatus;
	}

	public Email() {
		this.toList=new ArrayList<String>();
		this.ccList=new ArrayList<String>();
	}

	public Email(String From, String to, String Subject, String Message) {
		this();
		this.strFrom    = From;
		this.strSubject = Subject;
		this.strMessage = Message;
		this.toList.addAll(Arrays.asList(splitByComma(to)));
	}
    
	public Email(String From, String to, String cc, String Subject, String Message) {
		this();
		this.strFrom    = From;
		this.strSubject = Subject;
		this.strMessage = Message;
		this.toList.addAll(Arrays.asList(splitByComma(to))) ;
		this.ccList.addAll(Arrays.asList(splitByComma(cc)));
	}

	public String getStrFrom() {
		return strFrom;
	}

	public void setStrFrom(String strFrom) {
		this.strFrom = strFrom;
	}

	public List<String> getToList() {
		return toList;
	}

	public void setToList(List<String> toList) {
		this.toList = toList;
	}

	public List<String> getCcList() {
		return ccList;
	}

	public void setCcList(List<String> ccList) {
		this.ccList = ccList;
	}

	public String getStrSubject() {
		return strSubject;
	}

	public void setStrSubject(String strSubject) {
		this.strSubject = strSubject;
	}

	public String getStrMessage() {
		return strMessage;
	}

	public void setStrMessage(String strMessage) {
		this.strMessage = strMessage;
	}

	public boolean isHtml() {
		return isHtml;
	}

	public void setHtml(boolean isHtml) {
		this.isHtml = isHtml;
	}

	private String[] splitByComma(String toMultiple) {
		String[] split=toMultiple.split(",");
		return split;
	}
	public String getToAsList() {
		return AppUtil.concatenate(this.toList, ",");
	}
}
