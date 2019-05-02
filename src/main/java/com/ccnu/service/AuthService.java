package com.ccnu.service;

import com.ccnu.dao.User;
import com.ccnu.dao.UserExample;
import com.ccnu.mapper.UserMapper;
import com.ccnu.renum.ResultCode;
import com.ccnu.utils.JsonReult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by 董乐强 on 2019/5/2
 */

@Service
public class AuthService {

    @Autowired
    private UserMapper userMapper;


    /**
     * 用户登录
     * 1.查询数据库，该用户是否存在
     * 2.如果登录成功，则返回true,否则返回false
     * @param user
     * @return
     */
    public boolean login(User user){
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        String userName = user.getUsername();
        criteria.andUsernameEqualTo(userName);
        String password = user.getPassword();
        criteria.andPasswordEqualTo(password);
        List<User> list= userMapper.selectByExample(userExample);
        if(list.size()!=0)
            return true;
        return false;
    }


    /**
     * 用户注册
     * @param user
     * @return
     */
    public JsonReult register(User user){
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        //1.查询数据库，用户名是否存在，如果用户名存在则不能注册
        criteria.andUsernameEqualTo(user.getUsername());
        List<User> users = userMapper.selectByExample(userExample);
        if(users.size()>=1)
           return new JsonReult(ResultCode.UserNameExist);
        //2.用户名不存在，则进行注册
        int flag = userMapper.insertSelective(user);
        //注册成功
        if(flag>0)
            return new JsonReult(ResultCode.SUCCESS,user);
        //注册失败
        return new JsonReult(ResultCode.RegisterFail);

    }
}
