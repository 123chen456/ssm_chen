package com.chen.dao;

import com.chen.domain.Role;
import com.chen.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface IUserDao {

    @Insert("insert into users (email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo)throws Exception;
    /**
     * 查询所有的user信息
     * @return
     * @throws Exception
     */
    @Select("select * from users")
    List<UserInfo> findAll()throws Exception;

    /**
     * 根据用户名查询用户所有信息
     * @param username
     * @return
     */
    @Select("select * from users where username=#{username}")
    @Results(
            @Result(property = "roles",column = "id",javaType =java.util.List.class ,many = @Many(select="com.chen.dao.IRoleDao.findRolesByUser_Id"))
    )
    UserInfo findByName(String username)throws Exception;

    /**
     *
     * @param id
     * @return
     */
    @Select("select * from users where id = #{id}")
    @Results(
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "com.chen.dao.IRoleDao.findRolesByUser_Id"))
    )
    UserInfo findById(String id)throws Exception;

    /**
     *
     * @param id
     * @return
     */
    @Select("select * from role where id not in(select roleid from users_role where userid = #{id})")
    List<Role> findOtherRoles(String id)throws Exception;

    /**
     *
     * @param userId
     * @param ids
     */
    @Insert("insert into users_role values(#{userId},#{ids})")
    void addRoleToUser(@Param("userId") String userId,@Param("ids") String ids);
}
