package com.time.time.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.time.time.model.Task;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TaskMapper extends BaseMapper<Task> {
    List<Object> queryNews(String userName);
    List<Task> isHaveSameTask(String taskName,String userName);
}
