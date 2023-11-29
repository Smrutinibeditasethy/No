package com.wiprojobsearch.joblisting.controller;

import com.wiprojobsearch.joblisting.model.Post;
import com.wiprojobsearch.joblisting.model.User;
import com.wiprojobsearch.joblisting.service.PostService;
import com.wiprojobsearch.joblisting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

// Create a new controller for handling location filtering requests
@RestController
@RequestMapping("/api")
public class LocationFilterController {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @GetMapping("/filter/users")
    public ResponseEntity<List<User>> filterUsersByLocation(@RequestParam Set<String> locations) {
        List<User> filteredUsers = userService.getFilteredUsers(locations);
        return ResponseEntity.ok(filteredUsers);
    }

    @GetMapping("/filter/posts")
    public ResponseEntity<List<Post>> filterPostsByLocation(@RequestParam Set<String> locations) {
        List<Post> filteredPosts = postService.getFilteredPosts(locations);
        return ResponseEntity.ok(filteredPosts);
    }
}

