package org.example.subscriptionsportswebsite.repository;

import org.example.subscriptionsportswebsite.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
    User findByEmail(String email);
    User findByUserNameAndPassword(String userName, String password);
}
