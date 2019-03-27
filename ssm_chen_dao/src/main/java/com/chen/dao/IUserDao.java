package com.chen.dao;

import com.chen.domain.Role;
import com.chen.domain.UserInfo;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;


public interface IUserDao {

    /**
     * 根据用户名查询用户所有信息
     * @param username
     * @return
     */
    @Select("select * from users where username=#{username}")
    @Results(
            @Result(property = "roles",column = "id",javaType =java.util.List.class ,many = @Many(select="com.chen.dao.IRoleDao.findRolesByUser_Id"))
    )
    public UserInfo findByName(String username)throws Exception;
}
