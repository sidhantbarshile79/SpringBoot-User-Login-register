package com.user.loginandregister.DAO;

import com.user.loginandregister.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
