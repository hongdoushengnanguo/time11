package com.time.time.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.time.time.model.Task;

import java.util.List;


public interface TaskService extends IService<Task> {
    List<Object> queryNews(String userName);
    Integer addTask(Task task);
    List<Task> isHaveSameTask(String taskName,String userName);
    Integer updateTime( Task task);
    Integer delectPlan(String id);
}
