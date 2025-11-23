package com.Project.JobConnectPortal.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.Project.JobConnectPortal.Model.JobPostings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


@Repository
public interface JobPostingsRepo extends JpaRepository<JobPostings, Integer> {

    // Find job posting by jobId
	JobPostings findById(int jobId);
		List<JobPostings> findByJobName(String jobName);
	    List<JobPostings> findByCompanyName(String companyName);

    // Custom native query to fetch job trends insights
    @Query(value = "SELECT jp.job_name, jp.department, jp.skills, jp.experience, " +
            "AVG(jp.salary) AS average_salary, COUNT(*) AS total_postings " +
            "FROM job_postings jp " +
            "GROUP BY jp.job_name, jp.department, jp.skills, jp.experience " +
            "ORDER BY total_postings DESC", nativeQuery = true)
    List<Object[]> getJobTrendsInsights();
}
