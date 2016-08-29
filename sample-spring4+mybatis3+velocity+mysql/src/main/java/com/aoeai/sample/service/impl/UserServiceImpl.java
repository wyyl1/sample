package com.aoeai.sample.service.impl;

import com.aoeai.sample.bean.User;
import com.aoeai.sample.persistence.UserMapper;
import com.aoeai.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional
    @Override
    public User addUser(User user) {
        if (user == null) {
            throw new NullPointerException();
        }

        checkArgument(user);

        userMapper.addUser(user);

        return user;
    }

    @Override
    public void updateUser(User user) {
        if (user == null) {
        throw new NullPointerException();
        }
        if (user.getId() == null) {
            throw new IllegalArgumentException("Missing argument id ");
        }

        checkArgument(user);

        userMapper.updateUser(user);
    }

    @Override
    public User getUser(int id) {
        return userMapper.getUser(id);
    }

    @Override
    public Map<String, Object> getUserList(Map<String, Object> params) {
        Map<String, Object> result = new HashMap<String, Object>();

        if (params == null) {
            params = new HashMap<String, Object>();
            params.put("offset", 0);
            params.put("limit", 10);
        }

        if (params.get("offset") == null) {
            throw new IllegalArgumentException("Invalid argument offset");
        }

        if (params.get("limit") == null) {
            throw new IllegalArgumentException("Invalid argument limit");
        }

        result.put("count", userMapper.getUserCount(params));
        result.put("list", userMapper.getUserList(params));

        return result;
    }

    @Override
    public void deleteUser(int id) {
        userMapper.deleteUser(id);
    }

    /**
    * 验证参数合法性
    *
    * @param user
    */
    private void checkArgument(User user) {
// TODO
//        if (user.getApprove() != null && user.getApprove() != 0 && user.getApprove() != 1) {
//            throw new IllegalArgumentException("Invalid argument approve");
//        }
    }


}
