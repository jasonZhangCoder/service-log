package com.saferich.service.log;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.saferich.dao.log.user.model.User;

@Controller
@RequestMapping("test")
public class ServiceTest {

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    // @RequestParam(value = "name", required = true) String name
    public User account(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "name", required = true) String name) {
        User user = new User();
        user.setId(1);
        user.setName("zhangsan");
        return user;
    }

    @RequestMapping(value = "/user2", method = RequestMethod.POST)
    @ResponseBody
    // @RequestParam(value = "name", required = true) String name
    public User user2(HttpServletRequest request, HttpServletResponse response, @RequestBody User p_user) {
        if (p_user != null) {
            System.out.println(p_user.getName());
        }
        User user = new User();
        user.setId(1);
        user.setName("zhangsan");
        return user;
    }
}
