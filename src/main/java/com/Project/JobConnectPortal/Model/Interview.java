package com.Project.JobConnectPortal.Model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="Interview")
public class Interview {

    @Id
    private int interview_Id;
    private Date interview_date; 
	@ManyToOne
	@JoinColumn(name="application_id", referencedColumnName="application_id", insertable=false, updatable=false)
    
	private JobApplications application;

    private int application_id;
    private int userId;
    private String name;
    private String interview_status;
    private String feedback;
    
    public int getInterview_Id() {
		return interview_Id;
	}
	public void setInterview_Id(int interview_Id) {
		this.interview_Id = interview_Id;
	}
	public Date getInterview_date() {
		return interview_date;
	}
	public void setInterview_date(Date interview_date) {
		this.interview_date = interview_date;
	}
	public int getApplication_id() {
		return application_id;
	}
	public void setApplication_id(int application_id) {
		this.application_id = application_id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInterview_status() {
		return interview_status;
	}
	public void setInterview_status(String interview_status) {
		this.interview_status = interview_status;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public Interview() {}
	

    public Interview(int interview_Id, Date interview_date, int application_id, int userId, String name,
    		String interview_status, String feedback) {
    	this.interview_Id = interview_Id;
    	this.interview_date = interview_date;
    	this.application_id = application_id;
    	this.userId = userId;
    	this.name = name;
    	this.interview_status = interview_status;
    	this.feedback = feedback;
    }
}