package com.time.time.controller;

import com.time.time.model.Login;
import com.time.time.model.Record;
import com.time.time.model.Task;
import com.time.time.service.TaskNewsService;
import com.time.time.service.impl.LoginServiceImpl;
import com.time.time.service.impl.TaskServiceImpl;
import com.time.time.until.request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/plan")
public class TaskController {
    @Autowired
    TaskServiceImpl taskService;

    @Autowired
    private LoginServiceImpl loginService;
    @Autowired
    private TaskNewsService taskNewsService;
    @GetMapping("/planList")
    @ResponseBody
    public request  taskTist(Task task, HttpServletRequest re){
        request request=new request();
        List<Object> list =taskService.queryNews(re.getSession().getAttribute("userName").toString());
        request.setMsg("查找成功");
        request.setCode("1");
        request.setResult(list);

        return request;
    }

    @PostMapping("/planAdd")
    @ResponseBody
    public request  taskAdd(Task task, HttpServletRequest re){
        System.out.println(task+"123123++++++++++++++++++++++++++++++++++++++++++");
        request request=new request();
        Login login1 =loginService.queryByKey(re.getSession().getAttribute("userName").toString());
        task.setUsercode(login1.getUserCode());
        task.setUsername(login1.getUserName());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        task.setGreattime(df.format(new Date()));

        task.setId(UUID.randomUUID().toString().replace("-", "").toLowerCase());
        int a=0;
        if (taskService.isHaveSame(task.getTaskname(),task.getUsername())==0){
             a=taskService.addTask(task);
        }else{
            Task task1=taskService.isHaveSameTask(task.getTaskname(),task.getUsername()).get(0);
            task1.setTasktime(task.getTasktime());
            a=taskService.updateTime(task1);
        }
       if (a>=1){
           request.setMsg("成功");
           request.setCode("1");
       } else{
           request.setMsg("失败");
           request.setCode("2");
       }
        return request;
    }

    @PostMapping("/planDelect")
    @ResponseBody
    public request  delectPlan(String planId){
        request request=new request();
        int a= taskService.delectPlan(planId);
        if(a>=1){
            request.setMsg("成功");
            request.setCode("1");
        }else{
            request.setMsg("失败");
            request.setCode("2");
        }
        return request;
    }
    @PostMapping("/planStart" )
    @ResponseBody
    public request  planStart(@RequestParam Map<String,Object> map, HttpServletRequest re){
        System.out.println(map+"______________________________________________________________________________________");
        request request=new request();
        Record record=new Record();
        Task task1=taskService.isHaveSameTask(map.get("planName").toString(),re.getSession().getAttribute("userName").toString()).get(0);
        task1.setTasktime(Integer.parseInt(map.get("planTime").toString()));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        record.setGreatTime(df.format(new Date()));
        record.setId(UUID.randomUUID().toString().replace("-", "").toLowerCase());
        record.setIsFinish(0);
        record.setTaskCode(task1.getId());
        record.setTaskName(task1.getTaskname());
        record.setTime(Integer.parseInt(map.get("planTime").toString()));
        record.setUserCode(task1.getUsercode());
        record.setUserName(task1.getUsername());
        record.setTaskNews(task1.getTasknews());
        int b=taskNewsService.addTaskNews(record);
        int a=a=taskService.updateTime(task1);
        if(a>=1 && b>=1){
            request.setMsg("成功");
            request.setCode("1");
        }else{
            request.setMsg("失败");
            request.setCode("2");
        }
        return request;
    }

    @PostMapping("/planEnd")
    @ResponseBody
    public request  planEnd(@RequestParam Map<String,Object> map, HttpServletRequest re){
        request request=new request();
        Record record  = taskNewsService.selectTaskNews(map.get("planName").toString(),re.getSession().getAttribute("userName").toString()).get(0);
        record.setTime(Integer.parseInt(map.get("timeLength").toString()));
        record.setIsFinish(Integer.parseInt(map.get("sture").toString()));
        int a= taskNewsService.updateTaskNews(record);
        if(a>=1){
            request.setMsg("成功");
            request.setCode("1");
        }else{
            request.setMsg("失败");
            request.setCode("2");
        }
        return request;
    }

    @PostMapping("/graphs")
    @ResponseBody
    public request  gragphs( HttpServletRequest re){
        request request=new request();
        HashMap<String,Object> map1 =new HashMap<>();
        HashMap<String,Object> map2 =new HashMap<>();
        map2.put("series",taskNewsService.selectPie(re.getSession().getAttribute("userName").toString()));
        map1.put("Pie",map2);
        HashMap<String,Object> map3 =new HashMap<>();
        map3.put("series",taskNewsService.selectCol(re.getSession().getAttribute("userName").toString()));
        map1.put("Column",map3);
        request.setMsg("成功");
        request.setCode("1");
        request.setMap(map1);
        return request;
    }
}
