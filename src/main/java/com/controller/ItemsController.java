package com.controller;

import com.entity.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.service.ItemsService;

import java.util.List;

/**
 * @author:Yang
 * @date:2018/4/24
 */
@Controller
public class ItemsController {
    @Autowired
    private ItemsService itemsService;
    @RequestMapping("/queryItems")
    public ModelAndView queryItems() throws Exception{
        List<Items> list = itemsService.findItemsList();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("items",list);
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
