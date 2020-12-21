package com.group.demo.service;

import com.group.demo.entity.Thing;

import java.util.List;

/**
 * @author Tonghui Li
 * @createdTime 2020/3/14
 * @description
 */
public interface ThingService {

    List<Thing> queryAllThing();

    List<Thing> queryThingsByType(String type);

    List<String> queryTypes();
}
