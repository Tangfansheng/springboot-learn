package com.ordo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("hello")
public class HelloController {
    @RequestMapping("h1")
    @ResponseBody
    public String hello(){
        return "Hello, SpringBoot";
    }
}
