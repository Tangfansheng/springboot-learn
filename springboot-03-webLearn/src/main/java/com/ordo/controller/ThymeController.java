package com.ordo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
public class ThymeController {
    @RequestMapping("/test")
    public String index(Model model){
        model.addAttribute("msg","Hello, Thymeleaf");
        model.addAttribute("users", Arrays.asList("百年孤独","南方高速","寂寞的游戏"));
        return "test";
    }
}
