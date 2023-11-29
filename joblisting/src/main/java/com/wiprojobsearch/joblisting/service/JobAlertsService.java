/*
package com.wiprojobsearch.joblisting.service;

import com.wiprojobsearch.joblisting.model.JobAlertsRequest;
import com.wiprojobsearch.joblisting.model.Post;
import com.wiprojobsearch.joblisting.model.User;
import com.wiprojobsearch.joblisting.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class JobAlertsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostService postService; // Inject PostService for accessing recommended jobs

    public void setJobAlerts(String userId, JobAlertsRequest jobAlertsRequest) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        // Update user's preferred skills
        user.setPreferredSkills(jobAlertsRequest.getPreferredSkills());

        // Save the updated user
        userRepository.save(user);

        // Check for job alerts based on the new preferred skills
        checkJobAlertsForUser(user);
    }

    private void checkJobAlertsForUser(User user) {
        // Get recommended jobs based on user's preferred skills
        List<Post> recommendedJobs = postService.getRecommendedJobs(user.getId());

        // Check if any recommended job matches the user's preferences
        for (Post job : recommendedJobs) {
            if (matchesUserPreferences(job, user)) {
                // Send notification or perform other actions
                System.out.println("Alert: New job matches user preferences. Job ID: " + job.get_id());
            }
        }
    }

    private boolean matchesUserPreferences(Post job, User user) {
        Set<String> jobTechs = Set.of(job.getTechs());
        Set<String> userSkills = user.getPreferredSkills();

        // Check if any of the job's technologies match the user's preferred skills
        return jobTechs.stream().anyMatch(userSkills::contains);
    }
}*/


package com.wiprojobsearch.joblisting.service;

import com.wiprojobsearch.joblisting.model.JobAlertsRequest;
import com.wiprojobsearch.joblisting.model.Post;
import com.wiprojobsearch.joblisting.model.User;
import com.wiprojobsearch.joblisting.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class JobAlertsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostService postService;

    public List<String> getJobAlerts(String userId, JobAlertsRequest jobAlertsRequest) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        // Update user's preferred skills
        user.setPreferredSkills(jobAlertsRequest.getPreferredSkills());

        // Save the updated user
        userRepository.save(user);

        // Check for job alerts based on the new preferred skills
        return checkJobAlertsForUser(user);
    }

    private List<String> checkJobAlertsForUser(User user) {
        // Get recommended jobs based on user's preferred skills
        List<Post> recommendedJobs = postService.getRecommendedJobs(user.getId());

        List<String> matchedJobIds = new ArrayList<>();

        // Check if any recommended job matches the user's preferences
        for (Post job : recommendedJobs) {
            if (matchesUserPreferences(job, user)) {
                // Add the matched job ID to the list
                matchedJobIds.add(job.get_id());
            }
        }

        return matchedJobIds;
    }

    private boolean matchesUserPreferences(Post job, User user) {
        Set<String> jobTechs = Set.of(job.getTechs());
        Set<String> userSkills = user.getPreferredSkills();

        // Check if any of the job's technologies match the user's preferred skills
        return jobTechs.stream().anyMatch(userSkills::contains);
    }
}
