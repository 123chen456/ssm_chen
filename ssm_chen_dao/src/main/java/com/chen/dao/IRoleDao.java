package com.chen.dao;

import com.chen.domain.Role;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IRoleDao {
    /**
     * 根据user_id 查询role
     * @param id
     * @return
     */
    @Select("select * from role where id in(select roleId from users_role where userId = #{id})")
    @Results(
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "com.chen.dao.IPermissionDao.findByRoleId"))
    )
    List<Role> findRolesByUser_Id(String id);
}
