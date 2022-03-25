package com.example.demo.service;

import com.example.demo.controller.model.UserResponse;
import com.example.demo.dao.DaoFactory;
import com.example.demo.dao.base.UserDao;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {

    public List<UserResponse> fetchAll() {
        UserDao userDao = DaoFactory.getUserDao();

        return userDao
                .findAll()
                .stream()
                .map(m -> m.toDto())
                .collect(Collectors.toList());
    }
}
