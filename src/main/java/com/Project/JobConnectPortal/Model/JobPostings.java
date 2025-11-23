package com.Project.JobConnectPortal.Model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "job_postings")
public class JobPostings {

    @Id
    private int jobId;  

    @Column(name = "job_name")
    private String jobName;

    private String department;
    private String skills;
    private float experience;

    @Column(name = "job_description")
    private String jobDescription;

    private float salary;

    @Column(name = "post_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private String postDate; 

    @Column(name = "employer_id")
    private int employerId;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "status", columnDefinition = "VARCHAR(50) DEFAULT 'pending'")
    private String status;

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getjobName() {
        return jobName;
    }

    public void setjobName(String jobName) {
        this.jobName = jobName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public float getExperience() {
        return experience;
    }

    public void setExperience(float experience) {
        this.experience = experience;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public int getEmployerId() {
        return employerId;
    }

    public void setEmployerId(int employerId) {
        this.employerId = employerId;
    }

    public String getcompanyName() {
        return companyName;
    }

    public void setcompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;

    }

	public JobPostings() {
	
	
	}

	public JobPostings(int jobId, String jobName, String department, String skills, float experience,
			String jobDescription, float salary, String postDate, int employerId, String companyName,
			String status) {
		
		this.jobId = jobId;
		this.jobName = jobName;
		this.department = department;
		this.skills = skills;
		this.experience = experience;
		this.jobDescription = jobDescription;
		this.salary = salary;
		this.postDate = postDate;
		this.employerId = employerId;
		this.companyName = companyName;
		this.status = status;
	}
	
    
}


