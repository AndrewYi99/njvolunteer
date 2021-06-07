package com.njtc.njvolunteer.controller;

import com.njtc.njvolunteer.mapper.UserMapper;
import com.njtc.njvolunteer.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import javax.servlet.http.Cookie;

@Controller
public class RegisterController {

    @Resource
    private UserMapper userMapper;
    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user",new User());
        return "login";
    }


    @PostMapping("/registercheck")
    public String registercheck(HttpServletRequest request, HttpServletResponse response){
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        //随机生成一个token用来当cookies的value
        String token= UUID.randomUUID().toString();
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setToken(token);
        userMapper.insertuser(user);
        //如果用户注册成功，则把用户信息写进cookies，直接跳转到主页
        if(userMapper.selectUser(user)!=null){
            response.addCookie(new Cookie("token",token));
            return "redirect:/index";
        }else {
            //注册失败，处理方法先省略
            return "register";
        }
    }

}
