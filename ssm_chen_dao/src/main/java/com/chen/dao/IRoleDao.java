package com.chen.dao;

import com.chen.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IRoleDao {
    /**
     * 根据user_id 查询role
     * @param id
     * @return
     */
    @Select("select * from role where id in(select roleId from users_role where userId = #{id})")
    public List<Role> findRolesByUser_Id(String id);
}
