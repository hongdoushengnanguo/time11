package com.time.time.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.time.time.mapper.LoginMapper;
import com.time.time.model.Login;
import com.time.time.service.LoginService;
import org.springframework.stereotype.Service;


@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper, Login> implements LoginService {

    @Override
    public Login queryByKey(String userName) {
        return baseMapper.queryByKey(userName);

    }

    @Override
    public Integer addNews(Login login) {

        return baseMapper.insert(login);
    }
}
