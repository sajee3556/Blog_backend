package com.sajee.blog.service;

import com.sajee.blog.model.UserDetails;

public interface UserDetailsService {
    UserDetails findByUserDetailsId(int userDetailsId);
    UserDetails findByUserName(String userName);
    UserDetails save(UserDetails userDetails);
}
