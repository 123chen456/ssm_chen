package com.chen.service;

import com.chen.domain.Orders;

import java.util.List;

public interface IOrdersService {
    /**
     * 查询所有订单
     * @param page
     * @param pageSize
     * @return
     * @throws Exception
     */
    List<Orders> findAll(Integer page,Integer pageSize);

    /**
     * 根据id查询订单详细信息
     * @param id
     * @return
     * @throws Exception
     */
    Orders findById(String id);
}
