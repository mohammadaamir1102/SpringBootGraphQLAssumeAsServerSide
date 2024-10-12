package com.aamir.service;

import com.aamir.entity.User;
import com.aamir.exception.ExceptionHandler;
import com.aamir.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getUserById(int userId) {
        return userRepository.findById(userId).orElseThrow(ExceptionHandler::throwResourceNotFoundException);
    }

    public boolean deleteUserById(int userId) {
        User user = userRepository.findById(userId).orElseThrow(ExceptionHandler::throwResourceNotFoundException);
        userRepository.delete(user);
        return true;
    }
}
