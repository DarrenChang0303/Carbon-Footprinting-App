package com.group.demo.service;

import com.group.demo.entity.User;
import org.junit.Assert;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {


    @Autowired
    private UserService userService;


    @Test
    public void testLogin() {
        String userName="test";
        String password="123";
        User login = userService.login(userName, password);
        assertEquals("test",login.getName());

    }

    @Test
    public void testGetUserList() {
        List<User> userList = userService.getUserList();
        for (User user:userList) {
            System.out.println(user.toString());
        }
    }

    @Test
    public void testModifyUser() {
        User user=new User();
        user.setId(3);
        user.setName("name");
        user.setPassword("password");
        Boolean Boolean = userService.modifyUser(3, "name", "password");
        String name = userService.findUserById(3).getName();
        assertEquals("name",name);

    }

    @Test
    public void testFindUserById() {
        User userById = userService.findUserById(1);
        assertEquals("test",userById.getName());
    }

    @Test
    public void testAddUser() {
        User user=new User();
        user.setName("name");
        user.setPassword("password");
        Boolean aBoolean = userService.addUser(user);
        User userById = userService.findUserById(5);

        assertEquals("name",userById.getName());

    }


}
