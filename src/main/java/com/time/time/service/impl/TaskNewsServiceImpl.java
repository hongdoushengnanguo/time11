package com.time.time.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.time.time.mapper.TaskMapper;
import com.time.time.mapper.TaskNewsMapper;
import com.time.time.model.Record;
import com.time.time.model.Task;
import com.time.time.service.TaskNewsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskNewsServiceImpl extends ServiceImpl<TaskNewsMapper, Record> implements TaskNewsService {
    @Override
    public Integer addTaskNews(Record record) {
        return baseMapper.insert(record);
    }

    @Override
    public List<Record> selectTaskNews(String taskName,String userName) {
        return baseMapper.selectTaskNews(taskName,userName);
    }

    @Override
    public Integer updateTaskNews(Record record) {
        return baseMapper.updateById(record);
    }

    @Override
    public List<Object> selectPie(String userName) {
        return baseMapper.selectPie(userName);
    }

    @Override
    public List<Object> selectCol(String userName) {
        return baseMapper.selectCol(userName);
    }
}
