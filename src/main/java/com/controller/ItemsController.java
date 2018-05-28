package com.controller;

import com.entity.ItemsCustom;
import com.entity.ItemsQueryVo;
import com.entity.ValidGroup1;
import com.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.service.ItemsService;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
     * 商品分类
     * itemstypes表示最终将方法返回值放在request中的key
     */
    @ModelAttribute("itemstypes")
    public Map<String, String> getItemsTypes() {
        Map<String, String> itemType = new HashMap<String, String>();
        itemType.put("101", "数码");
        itemType.put("102", "母婴");
        return itemType;
    }

    /**
     * 查询商品信息
     *
     * @param model
     * @param itemsQueryVo
     * @return String
     * @throws Exception
     */
    @RequestMapping("/queryItems")

    public String queryItems(Model model, ItemsQueryVo itemsQueryVo) throws Exception {
        List<ItemsCustom> list = itemsService.findItemsList(itemsQueryVo);
        model.addAttribute("items", list);
        return "index";
    }

    /**
     * 商品信息修改页面展示
     *
     * @param model
     * @param items_id
     * @return String
     * @throws Exception
     */
    @RequestMapping("/editItems")
    public String editItems(Model model, @RequestParam(value = "id", required = true, defaultValue = "1") Integer items_id) throws Exception {
        ItemsCustom itemsCustom = itemsService.findItemsById(items_id);
        if (itemsCustom == null){
            throw new CustomException("商品信息不存在");
        }
        model.addAttribute("itemsCustom", itemsCustom);
        return "editItems";
    }

    /**
     * 修改商品信息提交
     *
     * @param id
     * @param itemsCustom
     * @return String
     * @throws Exception
     */
    @RequestMapping(value = "/editItemsSubmit")
    public String editItemsSubmit(Model model, Integer id,
                                  @Validated(value = ValidGroup1.class) ItemsCustom itemsCustom,
                                  BindingResult bindingResult,
                                  MultipartFile multipartFile) throws Exception {
        //异常处理
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError objectError : allErrors) {
                System.out.println(objectError.getDefaultMessage());
            }
            model.addAttribute("allErrors", allErrors);

            model.addAttribute("itemsCustom", itemsCustom);
            return "editItems";
        }
        //上传图片
        //获取文件原始名
        String originalFilename = multipartFile.getOriginalFilename();
        if (multipartFile != null && originalFilename!=null && originalFilename.length()>0 ){
            //存储图片物理物理路径
            String pic_path = "E:\\IdeaProjects\\ssm_itemsDemo\\pic\\";
            //新图片名称
            String newFileName = UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));
            //新图片
            File newFile = new File(pic_path+newFileName);
            //将内存中的数据写入磁盘
            multipartFile.transferTo(newFile);
            //将新图片名称写到itemsCustom
            itemsCustom.setPic(newFileName);

        }
        itemsService.updateItems(id, itemsCustom);
        return "success";
    }

    /**
     * 批量删除
     *
     * @param items_id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/deleteItems")
    public String deleteItems(Integer[] items_id) throws Exception {
        return "success";
    }

    @RequestMapping("/resultView/{id}")
    public @ResponseBody ItemsCustom resultView(@PathVariable("id") Integer id) throws Exception{
        ItemsCustom list= itemsService.findItemsById(id);
        return  list;
    }
}
