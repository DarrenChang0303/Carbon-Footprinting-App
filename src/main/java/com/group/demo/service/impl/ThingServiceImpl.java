package com.group.demo.service.impl;

import com.group.demo.dao.ThingDao;
import com.group.demo.entity.Thing;
import com.group.demo.service.ThingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Tonghui Li
 * @createdTime 2020/3/14
 * @description
 */
@Service
public class ThingServiceImpl implements ThingService {
    @Resource
    private ThingDao thingDao;

    @Override
    public List<Thing> queryAllThing() {
        return thingDao.queryAllThing();
    }

    @Override
    public List<Thing> queryThingsByType(String type) {
        return thingDao.queryThingsByType(type);
    }

    @Override
    public List<String> queryTypes() {
        return thingDao.queryTypes();
    }
}
