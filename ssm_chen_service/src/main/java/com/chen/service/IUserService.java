package com.chen.service;

import com.chen.domain.Role;
import com.chen.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    /**
     * 查询所有的用户信息
     * @return
     */
    List<UserInfo> findAll();

    /**
     * 添加用户
     * @param userInfo
     */
    void save(UserInfo userInfo);

    /**
     * 根据id查询用户详细信息
     * @param id
     * @return
     */
    UserInfo findById(String id);

    /**
     * 根据用户id查询用户没有的其他角色
     * @param id
     * @return
     */
    List<Role> findOtherRoles(String id);

    /**
     * 给用户添加角色
     * @param userId,ids
     */
    void addRoleToUser(String userId,String[] ids);
}
