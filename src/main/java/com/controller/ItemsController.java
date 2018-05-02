package com.controller;

import com.entity.ItemsCustom;
import com.entity.ItemsQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String queryItems(Model model,ItemsQueryVo itemsQueryVo) throws Exception {
        List<ItemsCustom> list = itemsService.findItemsList(itemsQueryVo);
        model.addAttribute("items", list);
        return "index";
    }

    /**
     * 商品信息修改页面展示
     */
    @RequestMapping("/editItems")
    public String editItems(Model model,@RequestParam(value = "id",required = true,defaultValue = "1") Integer items_id) throws Exception {
        ItemsCustom itemsCustom = itemsService.findItemsById(items_id);
        model.addAttribute("itemsCustom", itemsCustom);
        return "editItems";
    }

    /**
     * 商品信息提交
     */
    @RequestMapping(value = "/editItemsSubmit")
    public String editItemsSubmit(Integer id,ItemsCustom itemsCustom) throws Exception {
        itemsService.updateItems(id,itemsCustom);
        return "success";
    }
}
