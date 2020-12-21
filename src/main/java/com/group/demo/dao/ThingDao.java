package com.group.demo.dao;

import com.group.demo.entity.Thing;

import java.util.List;

/**
 * @author Tonghui Li
 * @createdTime 2019/11/24
 * @description
 */
public interface ThingDao {

    List<Thing> queryAllThing();

    List<Thing> queryThingsByType(String type);

    Thing queryThingById(Integer id);

    int insertThing(Thing thing);

    int updateThing(Thing thing);

    List<String> queryTypes();
}
