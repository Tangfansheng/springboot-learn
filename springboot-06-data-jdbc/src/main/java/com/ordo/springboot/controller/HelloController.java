package com.ordo.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class HelloController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/query")
    public List<Map<String, Object>> query(){
        String sql = "select * from mybatis.user";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

    @RequestMapping("/add")
    public String addUser(){
        String sql = "insert into mybatis.user(id, name, pwd) values (8,'audi','password')";
        jdbcTemplate.execute(sql);
        return "addUser_ok";
    }

    @RequestMapping("/update/{id}")
    public String updateUser(@PathVariable("id") Integer id){
        String sql = "update mybatis.user set name=?, pwd=? where id="+id;
        Object[] objects ={"ordo","helloworld"};
        jdbcTemplate.update(sql, objects);
        return "updateUser_ok";
    }
    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id){
        String sql = "delete from mybatis.user where id ="+id;
        jdbcTemplate.execute(sql);
        return "deleteUser_ok";
    }

}
