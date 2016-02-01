package com.saferich.service.log;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.saferich.api.log.ILogRemoteBusiness;

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
}
