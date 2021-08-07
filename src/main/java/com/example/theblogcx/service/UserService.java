package com.example.theblogcx.service;

import com.example.theblogcx.po.User;

public interface UserService {//检测用户名+密码

    User checkUser(String username, String password);
}
