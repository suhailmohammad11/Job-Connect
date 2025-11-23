package com.Project.JobConnectPortal.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Project.JobConnectPortal.Model.JobApplications;


@Repository
public interface JobApplicationsRepo extends JpaRepository<JobApplications, Integer> {

    // Custom methods to fetch applications by status, jobId, and userId

    List<JobApplications> findByStatus(String status);

    List<JobApplications> findByJobIdAndStatus(int jobId, String status);

    List<JobApplications> findByUserId(int userId);  

    List<JobApplications> findByUserIdAndStatus(int userId, String status);  

    // Custom methods to count applications by userId and status
    long countByUserId(int userId);

    long countByUserIdAndStatus(int userId, String status);

    // Custom query for job applications insights (moved from DAO)
    @Query(value = "SELECT ja.job_id, ja.job_role, ja.company_name, ja.name, " +
                   "SUM(CASE WHEN ja.status = 'applied' THEN 1 ELSE 0 END) AS applied_count, " +
                   "SUM(CASE WHEN ja.status = 'Interview Scheduled' THEN 1 ELSE 0 END) AS interview_scheduled_count, " +
                   "SUM(CASE WHEN ja.status = 'pending' THEN 1 ELSE 0 END) AS rejected_count " +
                   "FROM job_applications ja " +
                   "GROUP BY ja.job_id, ja.job_role, ja.company_name, ja.name", nativeQuery = true)
    List<Object[]> getJobApplicationsInsights();
}
