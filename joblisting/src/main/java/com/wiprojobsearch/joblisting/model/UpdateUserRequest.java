package com.wiprojobsearch.joblisting.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

public class UpdateUserRequest {

    private String id;

    @NotEmpty(message = "Fullname is required")
    private String fullName;

    @Email(message = "Invalid email format")
    @NotEmpty(message = "email is required")
    private String email;

    @NotEmpty(message = "Password is required")
    private String password;

    @NotEmpty(message = "Mobile number is required")
    private String mobileNumber;

    @NotEmpty(message = "workStatus is required")
    private String workStatus;

    private Set<String> skills;

    private Set<String> preferredSkills;

    private String location;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }

    public Set<String> getSkills() {
        return skills;
    }

    public void setSkills(Set<String> skills) {
        this.skills = skills;
    }

    public Set<String> getPreferredSkills() {
        return preferredSkills;
    }

    public void setPreferredSkills(Set<String> preferredSkills) {
        this.preferredSkills = preferredSkills;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
