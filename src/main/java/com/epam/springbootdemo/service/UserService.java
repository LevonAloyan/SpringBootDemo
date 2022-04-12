package com.epam.springbootdemo.service;

import com.epam.springbootdemo.model.User;

import java.util.List;

public interface UserService {

    User getUserById(Long id);

    List<User> getAllUsers();

    void saveUser(User user);

    void delete(Long id);

    void update(User user);

    User getByEmailAndPassword(String email, String password);
}
