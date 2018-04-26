package com.controller;

import com.entity.ItemsCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.service.ItemsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author:Yang
 * @date:2018/4/24
 */
@Controller
@RequestMapping("/items")
public class ItemsController {
    @Autowired
    private ItemsService itemsService;

    /**
     * 查询商品信息
     */
    @RequestMapping("/queryItems")
    public String queryItems(Model model) throws Exception {
        List<ItemsCustom> list = itemsService.findItemsList(null);
        model.addAttribute("items", list);
        return "index";
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
    @RequestMapping(value = "/editItemsSubmit",method = {RequestMethod.GET,RequestMethod.POST})
    public String editItemsSubmit() throws Exception {
        return "forward:/items/queryItems.action";
    }
}
