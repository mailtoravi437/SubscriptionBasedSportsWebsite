package org.example.subscriptionsportswebsite.services;

import org.example.subscriptionsportswebsite.Models.User;
import org.example.subscriptionsportswebsite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {
    @Autowired
    private UserRepository userRepository;

    public boolean loginUser(User user) {
        Optional<User> userFromDb = userRepository.findById(user.getId());
        if (userFromDb.isPresent()) {
            return userFromDb.get().getPassword().equals(user.getPassword());
        }
        return false;
    }

    public User registerUser(User user) {
        return userRepository.save(user);
    }
}