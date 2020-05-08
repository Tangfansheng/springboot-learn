package com.ordo.springboot.controller;

import com.ordo.springboot.mybatis.mapper.UserMapper;
import com.ordo.springboot.mybatis.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {
    @Autowired
    private UserMapper userMapper;
    @RequestMapping("/list")
    public String userList(){
        List<User> users = userMapper.selectUser();
        return users.toString();
    }

    //添加一个用户
    @GetMapping("/addUser")
    public String addUser(){
        userMapper.addUser(new User(10,"阿毛","456789"));
        return "ok";
    }
    //修改一个用户
    @GetMapping("/updateUser")
    public String updateUser(){
        userMapper.updateUser(new User(10,"阿毛","421319"));
        return "ok";
    }

}
