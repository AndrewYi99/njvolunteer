package com.njtc.njvolunteer.controller;

import com.njtc.njvolunteer.mapper.UserMapper;
import com.njtc.njvolunteer.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class mainController {
    @Resource
    private UserMapper userMapper;

    @RequestMapping("/index")
    public String showIndex(HttpServletRequest request,Model model){
        //把User写进session
                Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            String alterMsg = "你还未登录,请登录";
            model.addAttribute("msg",alterMsg);
            return "login";
        }
        User user = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")) {
                String token = cookie.getValue();
                user = userMapper.findBytoken(token);
                if (user != null) {
                    request.getSession().setAttribute("user", user);
                }
                break;
            }
        }
        return "index";
    }

    @RequestMapping("/showLogin")
    public String showLogin(){
        System.out.println("enter the index page");
        return "login";
    }


    @RequestMapping("/welcome")
    public String welcome(Model model){
        model.addAttribute("welcome","test for thyleaf");
        return "index";
    }

    @RequestMapping("/showNews")
    public String showNews(Model model){
        model.addAttribute("welcome","test for thyleaf");
        return "showNews";
    }
    @RequestMapping("/posts")
    public String showPostsDetails(){
        return "posts";
    }


    @RequestMapping("/showActivities")
    public String showActivities(){
        return "activities";
    }

    @RequestMapping("/shareIdea")
    public String showSareIdea(){
        return "shareIdea";
    }

    @RequestMapping("/showMessage")
    public String showMessage(){
        return "message";
    }

    @RequestMapping("/shareIdea_detail")
    public String showDetail(){
        return "shareIdea_detail";
    }

}
