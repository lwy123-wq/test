package com.controller;

import com.entity.User;
import com.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @RequestMapping(value = "/userLogin/submit", method = RequestMethod.POST)
    public String userLogin(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (userService.findByNameAndPassword(username, password) == null) {
            return "error";
        }
        return "success";
    }
    @RequestMapping(value = "/userRegister/submit", method = RequestMethod.POST)
    public String userRegister(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User u = new User(username, password);
        return userService.create(u);
    }
    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }
    @RequestMapping(value = "/register")
    public String register(){
        return "register";
    }
    //去注册页面
    @GetMapping("/register")
    public String toRegister(){
        return "register";
    }
    //去登陆页面
    @GetMapping("/login")
    public String toLogin(){
        return "login";
    }

}
