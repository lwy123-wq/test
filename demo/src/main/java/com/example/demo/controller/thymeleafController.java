package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class thymeleafController {
    @RequestMapping("/test")
    @ResponseBody
    public String test(Model model){
        model.addAttribute("msg","aaaaaaaaaaaaaaaaaaaaaaaa");
        return "hello1";
    }
/*    @RequestMapping

    public String test1(){
        return "aaa";
    }*/
}
