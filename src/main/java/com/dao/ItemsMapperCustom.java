package com.dao;

import com.entity.ItemsCustom;
import com.entity.ItemsQueryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author:Yang
 * @date:2018/4/24
 */

public interface ItemsMapperCustom {
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
     *修改商品信息提交
     * @param id
     * @param itemsCustom
     * @throws Exception
     */
    void updateItems(@Param("id") Integer id,@Param("itemsCustom") ItemsCustom itemsCustom) throws Exception;
}
