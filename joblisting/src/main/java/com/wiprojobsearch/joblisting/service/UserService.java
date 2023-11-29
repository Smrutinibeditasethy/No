package com.wiprojobsearch.joblisting.service;

import com.wiprojobsearch.joblisting.model.User;
import com.wiprojobsearch.joblisting.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public List<User> getFilteredUsers(Set<String> locations) {
        return userRepository.findByLocationIn(locations);
    }

}
