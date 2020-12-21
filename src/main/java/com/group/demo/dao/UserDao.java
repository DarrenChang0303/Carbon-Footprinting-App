package com.group.demo.dao;

import com.group.demo.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Tonghui Li
 * @createdTime 2019/11/21
 * @description
 */
public interface UserDao {

    User login(String userName, String password);

    User findUserById(Integer id);

    List<User> queryAllUsers();

    int updateUser(User user);

    int insertUser(User user);

    int deleteUser(Integer id);

    int getUserPoint(Integer id);
}
