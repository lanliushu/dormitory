package com.lanliushu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootTest
public class SpringBootTest04 {

    @Autowired
    DataSource data;

    @Test
    void printResult() throws Exception {
        //数据源
        System.out.println("数据源： " + data.getClass());
        //获取数据库连接
        Connection connection = data.getConnection();
        System.out.println("获取连接： " + connection);
    }
}
