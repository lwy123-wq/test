package com.controller;

import com.entity.User;
import com.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
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
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView login(String username,String password){

        User user=new User(username,password);
        System.out.println(user.getUsername());
        return new ModelAndView("/login.html");
    }
    @RequestMapping(value = "/registry",method =RequestMethod.POST)
    public ModelAndView register(String username,String password){
        if(userService.findByName(username)==null){
            userService.insertUser(username,password);
            return new ModelAndView("/login.html");
        }
        return new ModelAndView("error.html");
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
