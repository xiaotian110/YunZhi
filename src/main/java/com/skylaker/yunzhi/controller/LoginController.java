package com.skylaker.yunzhi.controller;

import com.alibaba.fastjson.JSONObject;
import com.skylaker.yunzhi.pojo.User;
import com.skylaker.yunzhi.service.IUserService;
import com.skylaker.yunzhi.utils.BaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: zhuyong
 * Date: 2018/5/12
 * Time: 11:55
 * Description: 用户登录管理
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    @Qualifier("userServiceImpl")
    private IUserService userService;

    /**
     * 获取登录页面
     *
     * @return
     */
    @RequestMapping("/getLoginPage")
    public String getLoginPage(){
        return "redirect:/login/login.do";
    }

    /**
     * 登录页面
     *
     * @return
     */
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    /**
     * 跳转到系统首页
     *
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String  index(){
        return "redirect:/index.jsp";
    }

    /**
     * 获取用户登录验证结果
     *
     * @param   user
     * @return
     */
    @RequestMapping(value = "/loginValidate", method = RequestMethod.POST)
    public @ResponseBody JSONObject loginValidate(@RequestBody User user){
        return BaseUtil.getResult(userService.userPwdValidate(user.getPhone(), user.getPassword()));
    }
}