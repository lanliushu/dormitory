package com.lanliushu.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    //后台监控
    @Bean
    public ServletRegistrationBean startViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");

        //自定义参数
        HashMap<String, String> initParameters = new HashMap<>();
        //增加配置
        //登录信息：登录的用户参数是固定的 loginUsername loginPassword
        initParameters.put("loginUsername", "admin");
        initParameters.put("loginPassword", "123123");
        //访问控制：白名单,空字符串表示允许任何人访问
        initParameters.put("allow", "");
        //访问控制：黑名单
        bean.setInitParameters(initParameters);
        return bean;
    }
}