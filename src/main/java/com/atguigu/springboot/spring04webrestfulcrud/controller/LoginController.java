package com.atguigu.springboot.spring04webrestfulcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping(value="/user")
public class LoginController {

    @PostMapping(value="/login")
    public String login(@RequestParam("username") String userName, @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){
        if (!StringUtils.isEmpty(userName) && userName.equals("admin")  && !StringUtils.isEmpty(password)) {
            //防止表单重复提交，重定向页面
            session.setAttribute("loginUser",userName);
            return "redirect:/main.html";
        }else{
            map.put("msg","用户名或者密码不对");
            return "login";
        }
    }
}
