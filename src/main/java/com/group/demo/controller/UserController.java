package com.group.demo.controller;

import com.group.demo.entity.User;
import com.group.demo.service.UserService;
import com.group.demo.util.Result;
import com.group.demo.util.ResultGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Tonghui Li
 * @createdTime 2019/11/21
 * @description
 */
@Controller
//@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    /**
     * @author Tonghui Li
     * @Description intercept access to pages
     * @Date 15:32 2020/4/25
     * @Param []
     * @Return java.lang.String
     **/
    @GetMapping({"/user/login","","/"})
    public String login(){
        return "user/login";
    }

    /**
     * @author Tonghui Li
     * @Description verify user
     * @Date 15:34 2020/4/25
     * @Param [userName, userPassword, session, request]
     * @Return java.lang.String
     **/
    @PostMapping("/user/login")
    public String login(@RequestParam("userName") String userName,
                        @RequestParam("password") String userPassword,
                        HttpSession session, HttpServletRequest request){
        if (StringUtils.isEmpty(userName)||StringUtils.isEmpty(userPassword)){
            session.setAttribute("errorMsg","please input username and password");
            return "user/login";
        }
        User user = userService.login(userName,userPassword);
        System.out.println(user);
        if (user!=null){
            session.setAttribute("loginUser",user.getName());
            session.setAttribute("loginUserId",user.getId());
            session.setMaxInactiveInterval(60 * 60 * 2);
            return "redirect:/user/index";
//            return "redirect:/thing/queryall";
        }else {
            session.setAttribute("errorMsg","login failed");
            return "user/login";
        }
    }

    /**
     * @author Tonghui Li
     * @Description return homepage
     * @Date 15:35 2020/4/25
     * @Param [request]
     * @Return java.lang.String
     **/
    @GetMapping("/user/index")
    public String index(HttpServletRequest request){
        int userId = (int) request.getSession().getAttribute("loginUserId");
        User user = userService.findUserById(userId);
        request.setAttribute("user",user);
        return "user/index";
    }

    /**
     * @author Tonghui Li
     * @Description insert new user
     * @Date 15:37 2020/4/25
     * @Param [userName, userPassword]
     * @Return com.group.demo.util.Result
     **/
    @PostMapping("/user/insert")
    @ResponseBody
    public Result insertUser(@RequestParam("userName") String userName,
                             @RequestParam("password") String userPassword){
        if (StringUtils.isEmpty(userName)||StringUtils.isEmpty(userPassword)){
            return ResultGenerator.genFailResult("please input user detail");
        }
        User user = new User();
        user.setName(userName);
        user.setPassword(userPassword);
        if (userService.addUser(user)){
            return ResultGenerator.genSuccessResult();
        }else {
            return ResultGenerator.genFailResult("insert failed");
        }
    }

    /**
     * @author Tonghui Li
     * @Description return the league table
     * @Date 15:37 2020/4/25
     * @Param [request]
     * @Return java.lang.String
     **/
    @GetMapping("/user/list")
    public String userList(HttpServletRequest request){
        List<User> users = userService.getUserList();
        request.setAttribute("userList",users);
        return "user/userList";
    }

    /**
     * @author Tonghui Li
     * @Description update user's name or password
     * @Date 15:40 2020/4/25
     * @Param [session, userName, password]
     * @Return com.group.demo.util.Result
     **/
    @PostMapping("/user/update")
    @ResponseBody
    public Result updateUser(HttpSession session,
                             @RequestParam("userName") String  userName,
                             @RequestParam("password") String password){
        int userId = (int) session.getAttribute("loginUserId");
        User user = new User();
        user.setId(userId);
        if (!StringUtils.isEmpty(userName)&&!StringUtils.isEmpty(password)){
            if (userService.modifyUser(userId,userName,password)){
                return ResultGenerator.genSuccessResult();
            }else {
                return ResultGenerator.genFailResult(userId+userName+password);
            }
        }
        return ResultGenerator.genFailResult("update failed");
    }
}
