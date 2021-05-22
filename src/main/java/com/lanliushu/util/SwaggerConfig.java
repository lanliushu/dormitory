package com.lanliushu.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 访问测试 ：http://localhost:8080/swagger-ui.html
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * 配置swagger2
     */
    @Bean
    public Docket docket(Environment environment){

        //获取项目环境：如果是dev或者是test返回true ,这个一般用于配置环境和发布环境的切换
//        Profiles profiles = Profiles.of("dev","test");
//        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            //是否开启swagger
            //.enable(false) false则在浏览器中无法访问
           // .groupName("User")  //配置分组，配置此分组为User分组
            .select() // 通过.select()方法，去配置扫描接口
            //RequestHandlerSelectors配置要扫描接口的方式 1、basePackage：基于包扫描
            // 2、withMethodAnnotation 扫描方法上的注解，这里写GetMapping.class表示
            //扫描GetMapping方法上的注解
            //3、withClassAnnotation，扫描类上的注解，这里写(Controller.class)表示
            //扫描有Controller注解的类中的接口
        .apis(RequestHandlerSelectors.basePackage("com.lanliushu.controller"))//
        //.apis(RequestHandlerSelectors.withMethodAnnotation(GetMapping.class))
        //.apis(RequestHandlerSelectors.withClassAnnotation(Controller.class))
            //paths(),通过路径过滤，只扫描什么路径下的文件
            //.paths(PathSelectors.ant("/alan/xxx"))
            //.any()  任何请求都扫描
            //.none() 任何请求都不扫描
            .build();
    }

    //配置多个分组写多几个docket即可
//    @Bean
//    public Docket docketA(){
//        return new Docket(DocumentationType.SWAGGER_2)
//        .groupName("A");//分组A的配置
    //      后续省略
//    }
//
//    @Bean
//    public Docket docketB(){
//        return new Docket(DocumentationType.SWAGGER_2)
//        .groupName("B");//分组B的配置
    //      后续省略
//    }

    /**
     * 配置Swagger信息 apiInfo
     */
    public ApiInfo apiInfo(){
        //作者信息
        Contact contact = new Contact("Alan ture",
                "www.baidu.com", "xxxxxx.qq.com");
        return new ApiInfo(
                "Alan ture SwaggerAPi文档",
                "这个是描述",
                "1.0",
                "www.baidu.com",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>());
    }

}
