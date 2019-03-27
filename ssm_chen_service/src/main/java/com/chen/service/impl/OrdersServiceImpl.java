package com.chen.service.impl;

import com.chen.dao.IOrdersDao;
import com.chen.domain.Orders;
import com.chen.service.IOrdersService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersDao ordersDao;

    @Override
    public List<Orders> findAll(Integer page,Integer pageSize){
        PageHelper.startPage(page,pageSize);
        List<Orders> list =new ArrayList<>();
        try {
            list = ordersDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Orders findById(String id){
        Orders orders=new Orders();
        try {
            orders = ordersDao.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }
}
