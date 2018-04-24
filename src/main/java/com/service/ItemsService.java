package com.service;

import com.entity.Items;

import java.util.List;

/**
 * @author:Yang
 * @date:2018/4/24
 */
public interface ItemsService {
    /**
     * 查询商品信息
     *
     * @return
     * @throws Exception
     */
    List<Items> findItemsList() throws Exception;
}
