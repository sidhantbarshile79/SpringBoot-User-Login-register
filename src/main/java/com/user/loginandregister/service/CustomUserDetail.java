package com.user.loginandregister.service;

import com.user.loginandregister.DAO.UserDAO;
import com.user.loginandregister.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetail implements UserDetailsService {

    private UserDAO userDAO;
    public CustomUserDetail(UserDAO userDAO)
    {
        this.userDAO=userDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user =  userDAO.findByUsername(username);
        if (user==null)
        {
            throw new UsernameNotFoundException("user not found with given username");

        }
        return org.springframework.security.core.userdetails.User.withUsername(user.getUsername()).password(user.getPassword()).roles(user.getRole()).build();
    }
}
