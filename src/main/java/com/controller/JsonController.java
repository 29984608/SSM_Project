package com.controller;

import com.entity.Items;
import com.entity.ItemsCustom;
import com.entity.User;
import com.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author:Yang
 * @date:2018/5/19
 */
@Controller
@RequestMapping("/json")
public class JsonController {
    @Autowired
    private ItemsService itemsService;
    @RequestMapping("/jsonTest")
    public @ResponseBody User jsonTest(@RequestBody User user){
        return user;
    }

}

