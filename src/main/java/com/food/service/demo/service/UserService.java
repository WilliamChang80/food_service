package com.food.service.demo.service;

import com.food.service.demo.domain.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public void createUser(User user);
    public void updateUser(User user, Long userID);
    public User getUserByID(Long userID);
    public void deleteUser(Long userID);
}
