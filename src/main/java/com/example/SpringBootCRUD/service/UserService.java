package com.example.SpringBootCRUD.service;

import com.example.SpringBootCRUD.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(long id);
    void delete(long id);
    void update(long id, User user);
    void add(User user);
}
