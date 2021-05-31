package com.njtc.njvolunteer.controller;

import com.njtc.njvolunteer.mapper.UserMapper;
import com.njtc.njvolunteer.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class loginController {
    @Resource
    private UserMapper userMapper;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user",new User());
        return "login";
    }

    @PostMapping("/logincheck")
    public String checklogin(HttpServletRequest request, HttpServletResponse response) {
        //通过request获取输入的用户名和密码在数据库中查找相关用户，如果存在就登陆成功
        User user = new User();
        String name = request.getParameter("loginName");
        String password = request.getParameter("loginPassword");
        user.setUsername(name);
        user.setPassword(password);
        User db_User = userMapper.selectUser(user);
        if (db_User != null) {
            String token = db_User.getToken();
            response.addCookie(new Cookie("token", token));


        } else {

            return "login";
        }
        return "redirect:/index";
    }

//    public String dologin(){
//        Cookie[] cookies = request.getCookies();
//        if (cookies == null) {
//            return "login";
//        }
//        User user = null;
//        for (Cookie cookie : cookies) {
//            if (cookie.getName().equals("token")) {
//                String token = cookie.getValue();
//                user = userMapper.findBytoken(token);
//                if (user != null) {
//
//                }
//                break;
//            }
//        }
//        return "index";
//    }

    //退出登陆
    @GetMapping("/logout")
    public String logout(HttpServletRequest request,
                         HttpServletResponse response, HttpSession session) {
        request.getSession().removeAttribute("user");
        Cookie cookie = new Cookie("token", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        System.out.println(session);
        return "redirect:/login";
    }
}
