package com.chen.dao;

import com.chen.domain.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPermissionDao {

    @Select("select * from permission where id in (select permissionId from role_permission where roleId = #{Role_Id})")
    List<Permission> findByRoleId(String Role_Id);
}
