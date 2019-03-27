package com.chen.dao;

import com.chen.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ITravellerDao {
    /**
     * 根据订单id查询旅客信息
     * @param order_id
     * @return
     */
    @Select("select * from traveller where id in(select travellerId from order_traveller where orderId=#{order_id})")
    List<Traveller> findByOrder_Id(String order_id)throws Exception;
}
