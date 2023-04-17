package  com.game.dice.controllers;

import  com.game.dice.models.User;

import  com.game.dice.repositories.UserRepository;

import  org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import  org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController extends  BaseController{

    public
    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public Object getAllUsers() {
        return sendResponse(userRepository.findAll(), "All users", HttpStatus.OK);
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable(value = "id") Integer userId) {
        return sendResponse(userRepository.findById(userId), "User by id", HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable(value = "id") Integer userId, @RequestBody User userDetails) {
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

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable(value = "id") Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(null);
        userRepository.delete(user);
    }
}