package com.service;

import com.entity.Items;
import com.entity.ItemsCustom;
import com.entity.ItemsQueryVo;

import java.util.List;

/**
 * @author:Yang
 * @date:2018/4/24
 */
public interface ItemsService {
    /**
     *
     * @param itemsQueryVo
     * @return
     * @throws Exception
     */
    List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
}
