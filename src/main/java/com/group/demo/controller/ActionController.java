package com.group.demo.controller;

import com.group.demo.dao.ActionDao;
import com.group.demo.dao.ThingDao;
import com.group.demo.dao.UserDao;
import com.group.demo.entity.Action;
import com.group.demo.entity.Thing;
import com.group.demo.entity.User;
import com.group.demo.service.ActionService;
import com.group.demo.service.ThingService;
import com.group.demo.service.UserService;
import com.group.demo.util.Result;
import com.group.demo.util.ResultGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Tonghui Li
 * @createdTime 2019/11/25
 * @description
 */
@Controller
@RequestMapping("/action")
public class ActionController {
    @Resource
    ActionDao actionDao;
    @Resource
    UserDao userDao;
    @Resource
    ThingDao thingDao;
    @Resource
    private ActionService actionService;

//    @GetMapping("/queryAll")
//    public String queryAllAction(HttpServletRequest request){
//        List<Action> actionList = actionDao.queryAllAction();
//        for (Action a: actionList) {
//            //set action.thing value
//            int thingId = a.getThing().getId();
//            Thing thing = thingDao.queryThingById(thingId);
//            a.setThing(thing);
//            //set action.user value
//            int userId = a.getActionUser().getId();
//            User user = userDao.findUserById(userId);
//            a.setActionUser(user);
//        }
//        request.setAttribute("actionList",actionList);
//        return "actionList";
//    }

    /**
     * @author Tonghui Li
     * @Description select action by current user
     * @Date 16:14 2020/3/14
     * @Param [request]
     * @Return java.lang.String
     **/
    @GetMapping("/query")
    public String queryActionByUser(HttpServletRequest request){

        int userId = (int) request.getSession().getAttribute("loginUserId");
        List<Action> actionList = actionService.queryActionByUser(userId);
        request.setAttribute("actionList",actionList);
        return "user/actionList";
    }

    /**
     * @author Tonghui Li
     * @Description add action to the list
     * @Date 13:50 2020/3/13
     * @Param [thingId, actionName, point, session]
     * @Return com.group.demo.util.Result
     **/
    @PostMapping("/add")
    @ResponseBody
    public Result addAction(@RequestParam("thingId") Integer thingId,
//                            @RequestParam("thingName") String actionName,
//                            @RequestParam("point") Double point,
                            HttpSession session){

        int userId = (int) session.getAttribute("loginUserId");
        if (actionService.addAction(userId,thingId)){
            return ResultGenerator.genSuccessResult();
        }else {
            return ResultGenerator.genFailResult("add action failed");
        }
    }
}
