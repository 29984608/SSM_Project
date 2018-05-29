package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author:Yang
 * @date:2018/5/29
 */
@Controller
public class LoginController {
    @RequestMapping("/login")
    public String login(HttpSession session, String username, String password)throws Exception{
        //调用service进行用户身份验证
        //...
        session.setAttribute("username",username);
        return "redirect:/items/queryItems";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session)throws  Exception{
        session.invalidate();
        return "redirect:login";
    }

}
