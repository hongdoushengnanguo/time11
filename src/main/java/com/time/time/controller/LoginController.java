package com.time.time.controller;

import com.time.time.model.Login;


import com.time.time.service.impl.LoginServiceImpl;
import com.time.time.until.request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Controller
@RequestMapping("/index")
public class LoginController  {
   @Autowired
   private LoginServiceImpl loginService;

    @GetMapping("/login")
    @ResponseBody
    public request Login(Login login, HttpServletRequest re)
    {
        request request=new request();
        Login login1 =loginService.queryByKey(login.getUserName());
        if (login.getPassword().equals(login1.getPassword())){
            request.setCode("1");
            request.setMsg("登陆成功");
            re.getSession().setAttribute("userName",login1.getUserName());
        }

     return  request;
    }
    @GetMapping("/zhuce")
    @ResponseBody
    public request zhuce( Login login)
    {
        request request=new request();
        login.setId( UUID.randomUUID().toString().replace("-", "").toLowerCase());
        Integer a=loginService .addNews(login);
        if (a==1){
            request.setCode("1");
            request.setMsg("注册成功");
        }
        return  request;
    }

}
