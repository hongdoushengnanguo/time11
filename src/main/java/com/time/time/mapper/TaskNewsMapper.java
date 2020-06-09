package com.time.time.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.time.time.model.Record;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TaskNewsMapper extends BaseMapper<Record> {
    List<Record> selectTaskNews(String  taskName,String userName );
    List<Object> selectPie(String userName );
    List<Object> selectCol(String userName );

}
