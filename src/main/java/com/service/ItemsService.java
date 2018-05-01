package com.service;

import com.entity.ItemsCustom;
import com.entity.ItemsQueryVo;

import java.util.List;

/**
 * @author:Yang
 * @date:2018/4/24
 */
public interface ItemsService {
    /**
     *查询商品信息
     *
     * @param itemsQueryVo
     * @return
     * @throws Exception
     */
    List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;

    /**
     * 根据id查询商品信息
     *
     * @param id 查询商品id
     * @return
     * @throws Exception
     */
    ItemsCustom findItemsById(Integer id) throws Exception;

    /**
     * 修改商品信息
     *
     * @param itemsCustom 修改商品信息
     * @throws Exception
     */
    void updateItems(Integer id,ItemsCustom itemsCustom) throws Exception;
}
