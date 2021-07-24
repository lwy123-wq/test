package com.controller;

import com.entity.User;
import com.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userService;

   /* @Autowired
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
    }*/
    @RequestMapping("/")
    public ModelAndView index(){
        return new ModelAndView("/index.html");
    }

    @RequestMapping(value = "/login")
    public ModelAndView login(){
        return new ModelAndView("/login.html");
    }
    @PostMapping(value = "/loginn")
    @ResponseBody
    public String login(String username,String password){
        System.out.println(username);
        User user=userService.findByNameAndPassword(username,password);

        if(user.getUsername()==null||user.getPassword()==null){
            return "error";
        }else {
            return "success";
        }
    }
    @RequestMapping(value = "/registry")
//    @ResponseBody
   public ModelAndView register(){
        return new ModelAndView("/registry.html");
    }
    @PostMapping(value = "/registrys")
    @ResponseBody
    public String  register(String username,String password){
        System.out.println("duan dian 1");
        User user =userService.findByName(username);
        System.out.println(user);
        if(user.getUsername() == null){
            userService.insertUser(username,password);
            return "Y";
        }
        return "N";
    }
    //去注册页面
  /*  @GetMapping("/register")
    public String toRegister(){
        return "register";
    }*/

    @RequestMapping("/demo")
    public String demo1(){return "/demo.html";}

    //去登陆页面
//    @GetMapping("/logins")





















































//    public String toLogin(){
//        return "/login";
//    }

}
