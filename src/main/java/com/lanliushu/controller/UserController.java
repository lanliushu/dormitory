package com.lanliushu.controller;

import com.lanliushu.entity.User;
import com.lanliushu.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@Api(tags = "用户类接口", description = "提供用户相关的 Rest API")
public class UserController {

    @Autowired
    UserService service;

    @ApiOperation("查询用户接口")
    @GetMapping("/user/{id}")
    public User selectUser(
            @ApiParam("用户id，用于查询") @PathVariable int id) {
        User user = service.selectUser(id);
        return user;
    }

    @ApiOperation("新增用户接口")
    @PostMapping("/user")
    public User inserUser(@RequestBody User user) {
        int num = service.inserUser(user);
        return user;
    }

    @ApiIgnore
    @DeleteMapping("/user/{id}")
    public int deleUser(@PathVariable int id) {
        int num = service.deleUser(id);
        return num;
    }

    @ApiOperation("修改用户接口")
    @PutMapping("/user")
    public User updateUser(@RequestBody User user) {
        int num = service.updateUser(user);
        return user;
    }

}
