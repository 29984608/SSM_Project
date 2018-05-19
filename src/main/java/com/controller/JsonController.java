package com.controller;

import com.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author:Yang
 * @date:2018/5/19
 */
@Controller
@RequestMapping("/json")
public class JsonController {
    @RequestMapping("/jsonTest")
    public @ResponseBody User jsonTest(@RequestBody User user){
        return user;
    }
}
