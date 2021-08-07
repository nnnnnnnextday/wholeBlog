package com.example.theblogcx.dao;

import com.example.theblogcx.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {//继承JPA

    User findByUsernameAndPassword(String username, String password);

}