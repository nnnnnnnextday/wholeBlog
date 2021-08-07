package com.example.wholeblog.service;

import com.example.wholeblog.po.User;

public interface UserService {

    User checkUser(String username,String password);
}
