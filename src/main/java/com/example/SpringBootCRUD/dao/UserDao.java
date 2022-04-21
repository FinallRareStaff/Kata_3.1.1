package com.example.SpringBootCRUD.dao;

import com.example.SpringBootCRUD.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    User getUserById(long id);
    void delete(long id);
    void update(long id, User user);
    void add(User user);
}
