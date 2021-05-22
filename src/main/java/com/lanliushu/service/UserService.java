package com.lanliushu.service;

import com.lanliushu.dao.UserMapper;
import com.lanliushu.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User selectUser(int id) {
        User user = userMapper.selectUser(id);
        return user;
    }

    public int inserUser(User user) {
        int num = userMapper.inserUser(user);
        return num;
    }

    public int deleUser(int id) {
        int num = userMapper.deleUser(id);
        return num;
    }

    public int updateUser(User user) {
        int num = userMapper.updateUser(user);
        return num;
    }
}
