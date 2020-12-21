package com.group.demo.service;


import com.group.demo.entity.Thing;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ThingServiceTest {

    @Autowired
    private ThingService thingService;

    @Test
    public void TestQueryAllThing() {
        List<Thing> things = thingService.queryAllThing();
        for (Thing thing:things) {
            System.out.println(thing.toString());
        }
    }

    @Test
    public void TestQueryThingsByType() {
        List<Thing> things = thingService.queryThingsByType("");
        for (Thing str:things) {
            System.out.println(str.toString());
        }    }

    @Test
    public void TestQueryTypes() {
        List<String> strings = thingService.queryTypes();
        for (String str:strings) {
            System.out.println(str);
        }
    }
}
