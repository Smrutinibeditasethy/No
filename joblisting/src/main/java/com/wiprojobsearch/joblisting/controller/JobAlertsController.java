/*
package com.wiprojobsearch.joblisting.controller;

import com.wiprojobsearch.joblisting.model.JobAlertsRequest;
import com.wiprojobsearch.joblisting.service.JobAlertsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users/{userId}/alerts")
public class JobAlertsController {

    @Autowired
    private JobAlertsService jobAlertsService;

    @PostMapping
    public ResponseEntity<Void> setJobAlerts(
            @PathVariable String userId,
            @RequestBody JobAlertsRequest jobAlertsRequest) {
        jobAlertsService.setJobAlerts(userId, jobAlertsRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}*/

package com.wiprojobsearch.joblisting.controller;

import com.wiprojobsearch.joblisting.model.JobAlertsRequest;
import com.wiprojobsearch.joblisting.service.JobAlertsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class JobAlertsController {

    @Autowired
    private JobAlertsService jobAlertsService;

    @PostMapping("/{userId}/alerts")
    public List<String> setJobAlerts(@PathVariable String userId, @RequestBody JobAlertsRequest jobAlertsRequest) {
        return jobAlertsService.getJobAlerts(userId, jobAlertsRequest);
    }
}

