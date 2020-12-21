package com.group.demo.dao;

import com.group.demo.entity.Action;
import com.group.demo.entity.User;

import java.util.List;

/**
 * @author Tonghui Li
 * @createdTime 2019/11/24
 * @description
 */
public interface ActionDao {

    List<Action> queryAllAction();

    List<Action> queryActionByUser(User user);

    int addAction(Action action);

    int updateAction(Action action);

}
