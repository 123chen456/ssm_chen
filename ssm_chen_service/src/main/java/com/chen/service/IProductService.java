package com.chen.service;

import com.chen.domain.Product;

import java.util.List;

public interface IProductService {

    public List<Product> findAll(Integer page,Integer Size);

    void save(Product product) throws Exception;
}
