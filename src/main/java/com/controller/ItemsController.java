package com.controller;

import com.entity.ItemsCustom;
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

    /**
     * 查询商品信息
     */
    @RequestMapping("/queryItems")
    public ModelAndView queryItems() throws Exception {
        List<ItemsCustom> list = itemsService.findItemsList(null);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("items", list);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    /**
     * 商品信息修改页面展示
     */
    @RequestMapping("/editItems")
    public ModelAndView editItems() throws Exception {
        ItemsCustom itemsCustom = itemsService.findItemsById(1);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsCustom", itemsCustom);
        modelAndView.setViewName("editItems");
        return modelAndView;
    }

    /**
     * 商品信息提交
     */
    @RequestMapping("/editItemsSubmit")
    public ModelAndView editItemsSubmit() throws Exception {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        return modelAndView;
    }
}
