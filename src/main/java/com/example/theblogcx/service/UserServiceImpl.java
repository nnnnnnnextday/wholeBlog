package com.example.theblogcx.service;

import com.example.theblogcx.dao.UserRepository;
import com.example.theblogcx.po.User;
import com.example.theblogcx.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired//(required=false)//注入
    private UserRepository userRepository;

    @Override
    public User checkUser(String username, String password) {//检测用户名+密码
        User user = userRepository.findByUsernameAndPassword(username, MD5Utils.code(password));//查询数据库
        return user;
    }

}
