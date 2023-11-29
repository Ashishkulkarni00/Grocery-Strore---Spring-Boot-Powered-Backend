package com.grocery.services;

import com.grocery.entities.User;
import com.grocery.exceptions.UserException;
import com.grocery.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public User createUser(User user){
        if(user.username.isEmpty()){
            throw new UserException("Username cannot be empty");
        }
        if(user.password.isEmpty()){
            throw  new UserException("Password cannot be empty");
        }
        if(user.email.isEmpty()){
            throw  new UserException("email cannot be empty");
        }
        if (user.roles.isEmpty()){
            throw  new UserException("please provide role of the user ROLE_ADMIN / ROLE_USER");
        }
        user.setPassword(passwordEncoder.encode(user.password));
        return userRepository.save(user);
    }

    public User updateUser(String username, User user){
        if(username.isEmpty() || user.getUsername().isEmpty() || user.getRoles().isEmpty() || user.getEmail().isEmpty() || user.getPassword().isEmpty()){
            throw new UserException("provide all the required details of the user");
        }
        if(userRepository.existsById(user.getUsername())){
            User exitstingUser = userRepository.findById(user.getUsername()).get();
            exitstingUser.setEmail(user.email);
            exitstingUser.setPassword(user.password);
            exitstingUser.setRoles(user.getRoles());
            return userRepository.save(exitstingUser);
        }else{
            throw new UserException("User with given username does not exist");
        }
    }
    public List<User> getAllUsers(){
        List<User> userList = userRepository.findAll();
        if(userList == null){
            throw new UserException("No users are available");
        }else{
            return userList;
        }
    }

    public User getUserByUserName(String username){
        if(userRepository.existsById(username)){
            return userRepository.findById(username).get();
        }else{
            throw new UserException("User with given userName does not exist");
        }
    }

    public String deleteByUserName(String username){
        if(userRepository.existsById(username)){
            userRepository.deleteById(username);
            return "user with " + username + " has been deleted";
        }else{
            throw new UserException("User with given " + username + " does not exist");
        }
    }
}