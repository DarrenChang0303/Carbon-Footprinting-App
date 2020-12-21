package com.group.demo.dao;

import com.group.demo.entity.User;
import com.group.demo.service.UserService;
import com.group.demo.entity.User;
import com.group.demo.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.swing.*;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
    @Resource
    private UserDao userDao;
    @Resource
    private UserServiceImpl userServiceImpl;
    @Resource
    private UserService userService;

    @Test
    public void TestLogin() {
        String userName = "test2", password = "321";
        User login = userDao.login(userName, password);
        assertEquals(login.getName(), "test2");
        assertEquals(login.getPassword(), "321");
    }

    @Test
    public void TestFindUserById() {
        int id = 2;
        User findUserById = userDao.findUserById(id);
        assertEquals(findUserById.getName(), "test2");
    }


    @Test
    public void TestUpdateUser() {
        //userServiceImpl.modifyUser(1, "test3", "1234");
        Integer id = 1;
        String userName = "test3";
        String password = "1234";

        User user = userDao.findUserById(id);
        if (user != null) {
            user.setName(userName);
            user.setPassword(password);
            userDao.updateUser(user);
        }
        assertEquals(userDao.findUserById(1).getName(), "test3");
        assertEquals(userDao.findUserById(1).getPassword(), "1234");
    }


}