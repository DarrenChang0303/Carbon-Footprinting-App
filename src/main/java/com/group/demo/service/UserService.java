package com.group.demo.service;

import com.group.demo.entity.User;

import java.util.List;

/**
 * @author Tonghui Li
 * @createdTime 2020/3/14
 * @description
 */
public interface UserService {
    User login(String userName,String password);

    List<User> getUserList();

    Boolean modifyUser(Integer id, String  userName, String password);

    User findUserById(Integer id);

    Boolean addUser(User user);
}
