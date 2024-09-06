package com.flipkart_Backend.demoFlipkart.Service;
import com.flipkart_Backend.demoFlipkart.Entity.User;
import com.flipkart_Backend.demoFlipkart.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUserById(String id) {
        userRepository.deleteById(id);
    }
}


//package com.flipkart_Backend.demoFlipkart.Service;
//import com.flipkart_Backend.demoFlipkart.Entity.User;
//import com.flipkart_Backend.demoFlipkart.Repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserService {
//    @Autowired
//    private UserRepository userRepository;
//
//    public User getUserById(String id) {
//        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
//    }
//
//    public User saveUser(User user) {
//        return userRepository.save(user);
//    }
//}





