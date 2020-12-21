package com.group.demo.service;

import com.group.demo.entity.Action;


import java.util.List;

/**
 * @author Tonghui Li
 * @createdTime 2020/3/14
 * @description
 */
public interface ActionService {

//    List<Action> queryAllAction();

    List<Action> queryActionByUser(Integer userId);

    Boolean addAction(Integer userId, Integer thingId);
}
