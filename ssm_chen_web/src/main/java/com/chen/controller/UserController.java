package com.chen.controller;

import com.chen.domain.Role;
import com.chen.domain.UserInfo;
import com.chen.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private IUserService iUserService;
    @RequestMapping("findAll.do")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        List<UserInfo> lists = iUserService.findAll();
        modelAndView.addObject("userList",lists);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }
    @RequestMapping("save.do")
    public String save(UserInfo userInfo){
        iUserService.save(userInfo);
        return "redirect:findAll.do";
    }
    @RequestMapping("findById.do")
    public ModelAndView UserDetail(@RequestParam(value = "id",required = true) String id){
        ModelAndView modelAndView = new ModelAndView();
        UserInfo userInfo=iUserService.findById(id);
        modelAndView.addObject("user",userInfo);
        modelAndView.setViewName("user-show");
        return modelAndView;
    }
    @RequestMapping("otherRoles.do")
    public ModelAndView otherRoles(@RequestParam(value = "id",required = true) String id){
        ModelAndView modelAndView = new ModelAndView();
        UserInfo userInfo =new UserInfo();
        List<Role> list=iUserService.findOtherRoles(id);
        userInfo.setId(id);
        modelAndView.addObject("user",userInfo);
        modelAndView.addObject("roleList",list);
        modelAndView.setViewName("user-role-add");
        return modelAndView;
    }
    @RequestMapping("addRoleToUser.do")
    public String addRoleToUser(@RequestParam(value = "ids",required = true) String[] ids,@RequestParam(value = "userId",required = true) String userId){
        iUserService.addRoleToUser(userId,ids);
        return "redirect:findById.do?id="+userId+"";
    }

}
