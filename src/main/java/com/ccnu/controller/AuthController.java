package com.ccnu.controller;

import com.ccnu.dao.User;
import com.ccnu.renum.ResultCode;
import com.ccnu.service.AuthService;
import com.ccnu.utils.JsonReult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.UUID;

/**
 * created by 董乐强 on 2019/5/2
 */
@Controller
public class AuthController {


    @Autowired
    private AuthService authService;


    /**
     *使用用户名和密码进行登录，用户名和密码保存在map里面
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public JsonReult loginUser(@RequestBody  Map<String,String> map){
        User user = new User();
        user.setPassword(map.get("password"));
        user.setUsername(map.get("username"));

        if(StringUtils.isEmpty(user.getUsername()))
            return new JsonReult("4002","用户名不能为空");
        if(StringUtils.isEmpty(user.getPassword()))
            return new JsonReult("4003","密码不能为空");

        boolean isSuccess = authService.login(user);

        if(isSuccess){
            JsonReult jsonReult = new JsonReult(ResultCode.SUCCESS.val(),"登录成功",user);
            return jsonReult;
        }
        return new JsonReult(ResultCode.FAIL.val(),"登录失败,用户名或者密码错误");
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public JsonReult register( @RequestBody  User user){
        String id = UUID.randomUUID().toString();
        user.setId(id);
        return authService.register(user);
    }



}
