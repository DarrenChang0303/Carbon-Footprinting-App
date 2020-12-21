package com.group.demo.controller;

import com.group.demo.dao.ThingDao;
import com.group.demo.entity.Thing;
import com.group.demo.service.ThingService;
import com.group.demo.util.Result;
import com.group.demo.util.ResultGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

/**
 * @author Tonghui Li
 * @createdTime 2019/11/24
 * @description
 */
@Controller
@RequestMapping("/thing")
public class ThingController {

    @Resource
    ThingService thingService;

    /**
     * @author Tonghui Li
     * @Description find all things in the list
     * @Date 15:27 2020/4/25
     * @Param [request]
     * @Return java.lang.String
     **/
    @GetMapping("/queryall")
    public String queryAllThing(HttpServletRequest request){
        List<Thing> thingList = thingService.queryAllThing();
        request.setAttribute("thingList",thingList);
        return "user/thingList";
    }

    /**
     * @author Tonghui Li
     * @Description find things by types
     * @Date 15:28 2020/4/25
     * @Param [type]
     * @Return com.group.demo.util.Result
     **/
    @GetMapping("/querybytype")
    @ResponseBody
    public Result queryByType(@RequestParam("type") String type){
        if (StringUtils.isEmpty(type)){
            return ResultGenerator.genFailResult("ERROR");
        }
        List<Thing> thingList = thingService.queryThingsByType(type);
        return ResultGenerator.genSuccessResult(thingList);
    }

    /**
     * @author Tonghui Li
     * @Description find all types
     * @Date 15:30 2020/4/25
     * @Param [request]
     * @Return java.lang.String
     **/
    @GetMapping("/queryTypes")
    public String queryTypes(HttpServletRequest request){
        List<String > types = thingService.queryTypes();
        request.setAttribute("typeList",types);
        return "user/thingList";
    }

//    @PostMapping("/insert")
//    @ResponseBody
//    public String insertThing(@RequestParam("name") String name,
//                              @RequestParam("type") String type,
//                              @RequestParam("description") String description,
//                              @RequestParam("points") double points){
//        if (StringUtils.isEmpty(name)||StringUtils.isEmpty(type)){
//            return "ERROR";
//        }
//        Thing thing = new Thing();
//        thing.setName(name);
//        thing.setType(type);
//        thing.setDescription(description);
//        thing.setPoints(points);
//        return ""+thingDao.insertThing(thing);
//    }
}
