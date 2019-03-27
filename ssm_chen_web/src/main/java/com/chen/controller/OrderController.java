package com.chen.controller;

import com.chen.domain.Orders;
import com.chen.domain.Traveller;
import com.chen.service.IOrdersService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private IOrdersService ios;
    @RequestMapping("/findAll.do")
    public ModelAndView findAllByPage(@RequestParam(name="page",required = true,defaultValue = "1")Integer page,@RequestParam(name="pageSize",required = true,defaultValue = "4")Integer pageSize){
        ModelAndView modelAndView = new ModelAndView();
        List<Orders> list = ios.findAll(page,pageSize);
        for (Orders orders : list) {
            System.out.println(orders.getId());
        }
        PageInfo pageInfo = new PageInfo(list);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("orders-page-list");
        return modelAndView;
    }
    @RequestMapping("/orderDetail.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true)String id){
        System.out.println(id);
        ModelAndView modelAndView = new ModelAndView();
        Orders orders = ios.findById(id);
        List<Traveller> travellers = orders.getTravellers();
        for (Traveller traveller : travellers) {
            System.out.println(traveller.getName());
        }
        modelAndView.addObject("orders",orders);
        modelAndView.setViewName("orders-show");
        return modelAndView;
    }
}
