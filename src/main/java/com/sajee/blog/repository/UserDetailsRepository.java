package com.sajee.blog.repository;

import com.sajee.blog.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> {
    UserDetails findByUserDetailsId(int userDetailsId);
    UserDetails findByUserName(String userName);
}
