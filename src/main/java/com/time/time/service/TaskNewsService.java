package com.time.time.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.time.time.model.Login;
import com.time.time.model.Record;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TaskNewsService extends IService<Record> {
    Integer addTaskNews(Record record);
    List<Record> selectTaskNews(String taskName,String userName);
    Integer updateTaskNews(Record record);
    List<Object> selectPie(String userName );
  List<Object> selectCol(String userName );
}
