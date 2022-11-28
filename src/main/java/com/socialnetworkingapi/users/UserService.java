package com.socialnetworkingapi.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired 
    UserRepository userRepository;

    public List<User> getAllUsers(){
        return  userRepository.findAll();
    }

    public User getUser(String id){
        return userRepository.findById(id).get();
    }

    public List<User> getUserByFirstName(String fname){
        return userRepository.getUserByFname(fname);
    }

    public List<User> getUserByLastName(String lname){
        return userRepository.getUserByLname(lname);
    }

    public void addUser(User user){
        userRepository.save(user);
    }

    public void updateUser(String id, User user){

        User us = userRepository.getReferenceById(id);
        us.setFname(user.getFname());
        us.setLname(user.getLname());
        us.setEmail(user.getEmail());
        us.setLocation(user.getLocation());

        userRepository.save(us);
    }

    public void deleteUser(String id){
        userRepository.delete(userRepository.getReferenceById(id));
    }
}
