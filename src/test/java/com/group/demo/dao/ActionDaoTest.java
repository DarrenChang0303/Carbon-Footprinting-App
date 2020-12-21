package com.group.demo.dao;

import com.group.demo.dao.UserDao;
import com.group.demo.entity.Thing;
import com.group.demo.entity.User;
import com.group.demo.entity.Action;
import com.group.demo.dao.ActionDao;
import com.group.demo.service.ActionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

public class ActionDaoTest {
    @Resource
    private ActionDao actiondao;
    @Resource
    private UserDao userDao;
    @Resource
    private ActionService actionService;
    @Resource
    private ThingDao thingDao;

    @Test
    public void TestQueryActionByUser() {
        List<Action> actionList = null;
        User user = userDao.findUserById(1);
        if (user != null) {
            actionList = actiondao.queryActionByUser(user);
        }

    }

    @Test
    public void TestAddAction() {
        User user = userDao.findUserById(1);
        Thing thing = thingDao.queryThingById(1);

        if (user != null && thing != null) {
            Double points = thing.getPoints();
            Action action = new Action();
            action.setThing(thing);
            action.setActionUser(user);
            action.setName(thing.getName());
            action.setPoint(points);
            user.setPoint(points + user.getPoint());
            actiondao.addAction(action);
        }


    }
}