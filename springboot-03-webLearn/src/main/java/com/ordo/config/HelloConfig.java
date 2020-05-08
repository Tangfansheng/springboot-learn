package com.ordo.config;


import com.ordo.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloConfig {
    @Bean
    //id为方法名 注入的内容为返回值
    public HelloService helloConfig01(){
        System.out.println("向容器中加入了自定义的组件->HelloService");
        return new HelloService();
    }
}
