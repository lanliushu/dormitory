package com.lanliushu.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("用户实体类")
public class User {

    @ApiModelProperty("用户id")
    private int uuid;
    @ApiModelProperty("用户名")
    private String userName;
    @ApiModelProperty("用户年龄")
    private int userAge;
    @ApiModelProperty("用户邮箱")
    private String userEmail;

    public User() {
    }

    public User(int uuid, String userName, int userAge, String userEmail) {
        this.uuid = uuid;
        this.userName = userName;
        this.userAge = userAge;
        this.userEmail = userEmail;
    }

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return "User{" +
                "uuid=" + uuid +
                ", userName='" + userName + '\'' +
                ", userAge=" + userAge +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}

