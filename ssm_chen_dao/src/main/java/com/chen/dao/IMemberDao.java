package com.chen.dao;

import com.chen.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface IMemberDao {
    /**
     * 根据id查询会员信息
     * @param id
     * @return
     */
    @Select("select * from member where id=#{id}")
    Member findById(String id) throws Exception;
}
