package com.time.time.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.time.time.mapper.TaskMapper;
import com.time.time.model.Task;
import com.time.time.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements TaskService {

    @Override
    public List<Object> queryNews(String userName) {
        return baseMapper.queryNews(userName);
    }

    @Override
    public Integer addTask(Task task) {
        return baseMapper.insert(task);
    }

    @Override
    public List<Task> isHaveSameTask(String taskName,String userName) {
        return baseMapper.isHaveSameTask(taskName,userName);
    }

    @Override
    public Integer updateTime(Task task) {
        return baseMapper.updateById(task);
    }

    @Override
    public Integer delectPlan(String id) {
        return baseMapper.deleteById(id);
    }


    public Integer  isHaveSame(String taskName,String userName){
        int a=1;
        List<Task >list = isHaveSameTask(taskName,userName);
       if(list.size()==0){
           a=0;
       }
        return a;
    }



}
