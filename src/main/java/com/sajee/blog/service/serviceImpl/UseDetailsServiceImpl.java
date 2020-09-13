package com.sajee.blog.service.serviceImpl;

import com.sajee.blog.model.UserDetails;
import com.sajee.blog.repository.UserDetailsRepository;
import com.sajee.blog.service.UserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UseDetailsServiceImpl implements UserDetailsService {
    public static final Logger logger = LoggerFactory.getLogger(UseDetailsServiceImpl.class);

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Override
    public UserDetails findByUserDetailsId(int userDetailsId) {
        return userDetailsRepository.findByUserDetailsId(userDetailsId);
    }

    @Override
    public UserDetails findByUserName(String userName) {
        return userDetailsRepository.findByUserName(userName);
    }

    @Override
    public UserDetails save(UserDetails userDetails) {
        try {
            return userDetailsRepository.save(userDetails);
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return null;
    }
}
