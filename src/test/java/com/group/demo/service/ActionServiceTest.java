package com.group.demo.service;

import com.group.demo.entity.Action;
import com.group.demo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ActionServiceTest {

    @Autowired
    private ActionService actionService;


    @Test
    public void TestQueryActionByUser() {
        List<Action> actions = actionService.queryActionByUser(2);
        for (Action action:actions) {
            System.out.println(action.toString());

        }
    }


    @Test
    public void TestAddAction() {
        Boolean aBoolean = actionService.addAction(1, 2);

        assertEquals(true,aBoolean);

    }

}
