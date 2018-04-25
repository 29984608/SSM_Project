package com.service.impl;

import com.dao.ItemsMapperCustom;
import com.entity.Items;
import com.entity.ItemsCustom;
import com.entity.ItemsQueryVo;
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
}
