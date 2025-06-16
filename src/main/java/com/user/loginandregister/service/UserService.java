package com.user.loginandregister.service;

import com.user.loginandregister.DAO.UserDAO;
import com.user.loginandregister.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    private final UserDAO userDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserService(UserDAO userDAO)
    {
        this.userDAO=userDAO;
    }

    public void registerUser(String username, String password )
    {
        User user= new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole("USER");
        userDAO.save(user);
    }
}
