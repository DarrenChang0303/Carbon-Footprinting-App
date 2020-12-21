package com.group.demo.service.impl;

import com.group.demo.dao.ActionDao;
import com.group.demo.dao.ThingDao;
import com.group.demo.dao.UserDao;
import com.group.demo.entity.Action;
import com.group.demo.entity.Thing;
import com.group.demo.entity.User;
import com.group.demo.service.ActionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Tonghui Li
 * @createdTime 2020/3/14
 * @description
 */
@Service
public class ActionServiceImpl implements ActionService {
    @Resource
    private ActionDao actionDao;
    @Resource
    private UserDao userDao;
    @Resource
    private ThingDao thingDao;

//    @Override
//    public List<Action> queryAllAction() {
//        return null;
//    }

    /**
     * @author Tonghui Li
     * @Description
     * @Date  2020/3/14
     * @Param [userId]
     * @Return java.util.List<com.group.demo.entity.Action>
     **/
    @Override
    public List<Action> queryActionByUser(Integer userId) {
        List<Action> actionList = null;
        User user = userDao.findUserById(userId);
        if (user != null){
            actionList = actionDao.queryActionByUser(user);
            for (Action a: actionList) {
                //set action.thing value
                int thingId = a.getThing().getId();
                Thing thing = thingDao.queryThingById(thingId);
                a.setThing(thing);
                //set action.user value
                int _userId = a.getActionUser().getId();
                User _user = userDao.findUserById(_userId);
                a.setActionUser(_user);
            }
        }
        return actionList;
    }

    /**
     * @author Tonghui Li
     * @Description
     * @Date 16:21 2020/3/14
     * @Param [userId, thingId]
     * @Return java.lang.Boolean
     **/
    @Override
    public Boolean addAction(Integer userId, Integer thingId) {
        User user = userDao.findUserById(userId);
        Thing thing = thingDao.queryThingById(thingId);
        if (user != null && thing != null){
            Double points = thing.getPoints();
            Action action = new Action();
            action.setThing(thing);
            action.setActionUser(user);
            action.setName(thing.getName());
            action.setPoint(points);
            //calculate user's points
            user.setPoint(points+user.getPoint());
            return actionDao.addAction(action) > 0 && userDao.updateUser(user) > 0;
        }
        return false;
    }
}
