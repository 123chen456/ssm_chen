package com.chen.controller;

import com.chen.domain.Product;
import com.chen.service.IProductService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService ips;

    //分页查询所有产品
    @RequestMapping("/findAll.do")
    public ModelAndView findAllByPage(@RequestParam(name="page",required = true,defaultValue = "1")Integer page,@RequestParam(name="pageSize",required = true,defaultValue = "4")Integer pageSize) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Product> lists = ips.findAll(page,pageSize);
        PageInfo pageInfo = new PageInfo(lists);
        System.out.println("pageInfo"+pageInfo);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("product-list");
        return modelAndView;
    }
    //添加产品
    @RequestMapping("/save.do")
    public String save(Product product) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        ips.save(product);
        return "redirect:findAll.do";
    }

}
