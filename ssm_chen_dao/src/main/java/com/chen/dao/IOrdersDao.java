package com.chen.dao;

import com.chen.domain.Member;
import com.chen.domain.Orders;
import com.chen.domain.Product;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface IOrdersDao {
    /**
     * 查询所有订单
     * @return
     * @throws Exception
     */
    @Select("select * from orders")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "com.chen.dao.IProductDao.findById",fetchType = FetchType.LAZY)),
    })
    public List<Orders> findAll() throws Exception;

    /**
     * 查询订单详情
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from orders where id= #{id}")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "com.chen.dao.IProductDao.findById",fetchType = FetchType.LAZY)),
            @Result(property = "member",column = "memberId",javaType = Member.class,one = @One(select = "com.chen.dao.IMemberDao.findById",fetchType = FetchType.LAZY)),
            @Result(property = "travellers",column = "id",javaType = java.util.List.class,many = @Many(select = "com.chen.dao.ITravellerDao.findByOrder_Id",fetchType = FetchType.LAZY)),
    })
    Orders findById(String  id) throws Exception;
}
