package com.time.time.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.time.time.model.Login;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper extends BaseMapper<Login> {

    Login queryByKey(String userName);
}
