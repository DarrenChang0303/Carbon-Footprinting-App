package com.group.demo.service.impl;

import com.group.demo.dao.UserDao;
import com.group.demo.entity.User;
import com.group.demo.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Tonghui Li
 * @createdTime 2020/3/14
 * @description
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User login(String userName, String password) {
        return userDao.login(userName,password);
    }

    @Override
    public List<User> getUserList() {
        return userDao.queryAllUsers();
    }

    @Override
    public Boolean modifyUser(Integer id, String  userName, String password) {
        User user = userDao.findUserById(id);
        if (user != null){
            user.setName(userName);
            user.setPassword(password);
            return userDao.updateUser(user) > 0;
        }
        return false;
    }

    @Override
    public User findUserById(Integer id) {
        return userDao.findUserById(id);
    }

    @Override
    public Boolean addUser(User user) {
        return userDao.insertUser(user) > 0;
    }
}
