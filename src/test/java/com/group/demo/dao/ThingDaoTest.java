package com.group.demo.dao;

import com.group.demo.entity.Action;
import com.group.demo.entity.Thing;
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

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest

public class ThingDaoTest {
    @Resource
    private UserDao userDao;
    @Resource
    private ActionDao actionDao;
    @Resource
    private ThingDao thingDao;

    @Test
    public void TestQueryThingById() {

        String id_thing = "1", point = "1.0";
        String id_name = "Litter", type = "LitterPicking", description = "desc1";

        Thing CompareQueryThingById = thingDao.queryThingById(1);
        String get_id = Integer.toString(CompareQueryThingById.getId());
        String a = Double.toString(CompareQueryThingById.getPoints());


        assertEquals(get_id, id_thing);
        assertEquals(a, point);
        assertEquals(CompareQueryThingById.getType(), type);
        assertEquals(CompareQueryThingById.getName(), id_name);
        assertEquals(CompareQueryThingById.getDescription(), description);

    }


    @Test
    public void TestQueryTypes() {

        assertNotNull(thingDao.queryTypes());
        assertTrue(thingDao.queryTypes().contains("LitterPicking"));
        assertTrue(thingDao.queryTypes().contains("Recycling"));
        assertTrue(thingDao.queryTypes().contains("ReusableItems"));
    }
}