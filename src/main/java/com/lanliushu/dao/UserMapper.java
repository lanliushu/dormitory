package com.lanliushu.dao;

import com.lanliushu.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    User selectUser(int id);

    int inserUser(User user);

    int deleUser(int id);

    int updateUser(User user);
}
