package com.game.dice.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.game.dice.repositories.UserRepository;
import com.game.dice.models.User;

import java.util.List;
import java.util.Optional;

@Service


public class UserServices {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Integer userId) {
        return userRepository.findById(userId);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Integer userId, User userDetails) {
        User user = userRepository.findById(userId).orElseThrow(null);
        user.setLast_name(userDetails.getLast_name());
        user.setFirst_name(userDetails.getFirst_name());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        user.setPhone_number(userDetails.getPhone_number());
        user.setAddress(userDetails.getAddress());
        User updatedUser = userRepository.save(user);
        return updatedUser;
    }

    public void deleteUser(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(null);
        userRepository.delete(user);
    }

}
