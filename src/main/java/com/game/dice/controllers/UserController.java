package  com.game.dice.controllers;

import com.game.dice.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import  org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController extends  BaseController{

    @Autowired
    private UserServices userServices;
    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
            return sendResponse(userServices.getAllUsers(), "Users retrieved successfully", HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Integer id) {
            return sendResponse(userServices.getUserById(id), "User retrieved successfully", HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody com.game.dice.models.User user) {
            return sendResponse(userServices.createUser(user), "User created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Integer id, @RequestBody com.game.dice.models.User user) {
            return sendResponse(userServices.updateUser(id, user), "User updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
            userServices.deleteUser(id);
            return sendInfo("User deleted successfully", HttpStatus.OK);
    }



}
