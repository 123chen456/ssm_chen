package com.chen.service.impl;

import com.chen.dao.IProductDao;
import com.chen.domain.Product;
import com.chen.service.IProductService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    @Override
    public void save(Product product) {
        try {
            productDao.save(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> findAll(Integer page,Integer pageSize){
        List<Product> list=new ArrayList<Product>();
        PageHelper.startPage(page,pageSize);
        try {
            list = productDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
