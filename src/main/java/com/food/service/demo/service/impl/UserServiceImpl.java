package com.food.service.demo.service.impl;

import com.food.service.demo.domain.User;
import com.food.service.demo.repository.UserRepository;
import com.food.service.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    public User getUserByID(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void updateUser(User user, Long userID) {
        User updatedUser = getUserByID(userID);
        updatedUser.setUserName(user.getUserName())
                .setAddress(user.getAddress())
                .setPhoneNumber(user.getPhoneNumber())
                .setAge(user.getAge());
        userRepository.save(updatedUser);
    }

    @Override
    public void deleteUser(Long userID) {
        User deletedUser = getUserByID(userID);
        userRepository.delete(deletedUser);
    }
}
