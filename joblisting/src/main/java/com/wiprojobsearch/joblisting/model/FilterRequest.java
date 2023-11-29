package com.wiprojobsearch.joblisting.model;

import java.util.Set;

public class FilterRequest {

    private Set<String> companyNames;
    private Set<String> skills;

    public FilterRequest(Set<String> companyNames, Set<String> skills) {
        this.companyNames = companyNames;
        this.skills = skills;
    }

    public Set<String> getCompanyNames() {
        return companyNames;
    }

    public void setCompanyNames(Set<String> companyNames) {
        this.companyNames = companyNames;
    }

    public Set<String> getSkills() {
        return skills;
    }

    public void setSkills(Set<String> skills) {
        this.skills = skills;
    }
}
