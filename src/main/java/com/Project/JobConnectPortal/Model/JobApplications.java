package com.Project.JobConnectPortal.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "job_applications")
public class JobApplications {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")  
    private int applicationId;

    @Column(name = "job_id")  
    private int jobId;

    @Column(name = "job_role")  
    private String jobRole;

    @Column(name = "company_name")  
    private String companyName;

    @Column(name = "employer_id")  
    private int employerId;

    @Column(name = "user_id")  
    private int userId;

    @Column(name = "name")  
    private String name;

    @Column(name = "qualification")  
    private String qualification;

    @Column(name = "resume_url")  
    private String resumeUrl;

    @Column(name = "mobile")  
    private long mobile;

    @Column(name = "email")  
    private String email;

    @Column(name = "experience") 
    private float experience;

    @Column(name = "applied_at", nullable = false, columnDefinition = "VARCHAR(50) DEFAULT 'applied'")  
    private String appliedAt = "applied"; 

    @Column(name = "status", nullable = false, columnDefinition = "VARCHAR(50) DEFAULT 'pending'")  
    private String status = "pending";  

    public JobApplications() {}

    public JobApplications(int jobId, String jobRole, String companyName, int employerId, int userId, String name, 
                            String qualification, String resumeUrl, long mobile, String email, 
                            float experience, String appliedAt, String status) {
        this.jobId = jobId;
        this.jobRole = jobRole;
        this.companyName = companyName;
        this.employerId = employerId;
        this.userId = userId;
        this.name = name;
        this.qualification = qualification;
        this.resumeUrl = resumeUrl;	
        this.mobile = mobile;
        this.email = email;
        this.experience = experience;
        this.appliedAt = appliedAt;
        this.status = status;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getEmployerId() {
        return employerId;
    }

    public void setEmployerId(int employerId) {
        this.employerId = employerId;
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

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getResumeUrl() {
        return resumeUrl;
    }

    public void setResumeUrl(String resumeUrl) {
        this.resumeUrl = resumeUrl;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getExperience() {
        return experience;
    }

    public void setExperience(float experience) {
        this.experience = experience;
    }

    public String getAppliedAt() {
        return appliedAt;
    }

    public void setAppliedAt(String appliedAt) {
        this.appliedAt = appliedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
