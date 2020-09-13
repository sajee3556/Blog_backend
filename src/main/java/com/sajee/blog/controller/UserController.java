package com.sajee.blog.controller;

import com.sajee.blog.model.UserDetails;
import com.sajee.blog.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserDetailsService userDetailsService;

    @RequestMapping(value = "/saveUserDetails", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<UserDetails> saveUserDetails(@RequestBody UserDetails userDetails) {
        return ResponseEntity.ok(userDetailsService.save(userDetails));
    }

    @RequestMapping(value = "/getUserDetails", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<UserDetails> getUserDetails(@RequestParam String userName) {
        return ResponseEntity.ok(userDetailsService.findByUserName(userName));
    }
}
