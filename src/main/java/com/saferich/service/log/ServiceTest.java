package com.saferich.service.log;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.saferich.api.log.ILogRemoteBusiness;
import com.saferich.dao.log.user.model.User;

@Controller
@RequestMapping("test")
public class ServiceTest {

    @Autowired
    private ILogRemoteBusiness logRemoteBusiness;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public String account(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("ok!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        logRemoteBusiness.printOut();
        return "true";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ResponseBody
    public String addUser(HttpServletRequest request, HttpServletResponse response, @RequestBody User user) {
        /*
         * User user = new User(); user.setAge(age); user.setName(name);
         */
        System.out.println(user.getName());
        logRemoteBusiness.addUser(user);
        return "true";
    }

    @RequestMapping(value = "/delUser", method = RequestMethod.DELETE)
    @ResponseBody
    public String delUser(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "id", required = true) int id) {
        logRemoteBusiness.delUser(id);
        return "true";
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    @ResponseBody
    public String updateUser(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "id", required = true) int id,
            @RequestParam(value = "name", required = true) String name, @RequestParam(value = "age", required = true) int age) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        logRemoteBusiness.updateUser(user);
        return "true";
    }

    @RequestMapping(value = "/findAllUser", method = RequestMethod.POST)
    @ResponseBody
    public List<User> findAllUser(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(logRemoteBusiness.findAllUser().size());
        return logRemoteBusiness.findAllUser();
    }
}
