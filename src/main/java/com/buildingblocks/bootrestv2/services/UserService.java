package com.buildingblocks.bootrestv2.services;

import com.buildingblocks.bootrestv2.entities.User;
import com.buildingblocks.bootrestv2.exceptions.UserExistsException;
import com.buildingblocks.bootrestv2.exceptions.UserNotFoundException;
import com.buildingblocks.bootrestv2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) throws UserExistsException {
        User existingUser = userRepository.findByUsername(user.getUsername());
        if(existingUser != null){
            throw new UserExistsException("User already exists in repository.");
        }

        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long id) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(id);

        if(!user.isPresent()){
            throw new UserNotFoundException("User not found in user repository");
        }

        return user;
    }

    public User updateUserById(Long id, User user) throws UserNotFoundException{
        Optional<User> optionalUser = userRepository.findById(id);

        if(!optionalUser.isPresent()){
            throw new UserNotFoundException("User not found in user repository, provide the correct user id");
        }


        user.setId(id);
        return userRepository.save(user);
    }

    public void deleteUserById(Long id) throws ResponseStatusException{
        Optional<User> optionalUser = userRepository.findById(id);

        if(!optionalUser.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"User not found in user repository");
        }
        userRepository.deleteById(id);
    }

    //getUserByUsername
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
