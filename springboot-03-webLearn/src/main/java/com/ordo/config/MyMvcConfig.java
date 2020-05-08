package com.ordo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    //页面跳转功能实现
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/diy").setViewName("test");
    }
}
