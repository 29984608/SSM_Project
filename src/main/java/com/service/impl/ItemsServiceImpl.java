package com.service.impl;

import com.dao.ItemsMapperCustom;
import com.entity.Items;
import com.entity.ItemsCustom;
import com.entity.ItemsQueryVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.service.ItemsService;

import java.util.List;

/**
 * @author:Yang
 * @date:2018/4/24
 */
@Service
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    ItemsMapperCustom itemsMapperCustom;

    @Override
    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
        return itemsMapperCustom.findItemsList(itemsQueryVo);
    }

    @Override
    public ItemsCustom findItemsById(Integer id) throws Exception {
        Items items= itemsMapperCustom.findItemsById(id);
        /**
         * 中间对商品信息进行业务处理
         * ...
         *返回ItemsCustom
         */
        ItemsCustom itemsCustom = new ItemsCustom();
        //将items的属性拷贝到itemsCustom
        BeanUtils.copyProperties(items,itemsCustom);
        return itemsCustom;
    }

    @Override
    public void updateItems(Integer id,ItemsCustom itemsCustom) throws Exception {
        //添加业务效验，判断id是否为空
        itemsMapperCustom.updateItems(id,itemsCustom);
    }
}
