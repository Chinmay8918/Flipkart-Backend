package com.flipkart_Backend.demoFlipkart.Controllers;

import com.flipkart_Backend.demoFlipkart.Entity.User;
import com.flipkart_Backend.demoFlipkart.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Get user by ID
    @GetMapping("/{id}")
    public User getUser(@PathVariable String id) {
        return userService.getUserById(id);
    }


    // Get all users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Create a new user
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    // Update user by ID
    @PutMapping("/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User user) {
        user.setId(id);
        return userService.updateUser(user);
    }

    // Delete user by ID
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUserById(id);
    }
}

//package com.flipkart_Backend.demoFlipkart.Controllers;
//import com.flipkart_Backend.demoFlipkart.Entity.User;
//import com.flipkart_Backend.demoFlipkart.Service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/users")
//public class UserController {
//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/{id}")
//    public User getUser(@PathVariable String id) {
//        return userService.getUserById(id);
//    }
//
//    @PostMapping("/add")
//    public User createUser(@RequestBody User user) {
//        return userService.saveUser(user);
//    }
//}

