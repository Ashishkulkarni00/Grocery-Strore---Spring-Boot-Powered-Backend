package com.grocery.contorllers;

import com.grocery.entities.User;
import com.grocery.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{userName}")
    public User getUserByUserName(@PathVariable String userName){
        return userService.getUserByUserName(userName);
    }

    @PostMapping
    public User createUser(@RequestBody User user){
       return userService.createUser(user);
    }

    @DeleteMapping("/{userName}")
    public String deleteUserByUserName(@PathVariable String username){
        return userService.deleteByUserName(username);
    }

}
