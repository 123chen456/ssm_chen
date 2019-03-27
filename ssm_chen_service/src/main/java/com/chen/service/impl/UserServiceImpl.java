package com.chen.service.impl;

import com.chen.dao.IUserDao;
import com.chen.domain.Role;
import com.chen.domain.UserInfo;
import com.chen.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service(value = "userService")
@Transactional
public class UserServiceImpl implements IUserService{
    @Autowired
    private IUserDao iUserDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo =null;
        try {
            userInfo = iUserDao.findByName(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //将自己的对象(userInfo)封装为UserDetail
        //User是UserDetails的一个实现类
        //password 前+{noop}:告诉它我没有进行加密
        //User user = new User(userInfo.getUsername(), "{noop}"+userInfo.getPassword(), getAutority(userInfo.getRoles()));
        User user = new User(userInfo.getUsername(), "{noop}"+userInfo.getPassword(),userInfo.getStatus()==0 ? false :true,true,true,true,getAutority(userInfo.getRoles()));
        return user;
    }
    //封装用户描述
    public List<SimpleGrantedAuthority> getAutority(List<Role> roles){
        List<SimpleGrantedAuthority> list=new ArrayList<>();
        for (Role role : roles) {
            String roleName = role.getRoleName();
            list.add(new SimpleGrantedAuthority("ROLE_"+roleName));
            System.out.println("ROLE_"+roleName);//ROLE_ADMIN
        }
        return list;
    }
}
