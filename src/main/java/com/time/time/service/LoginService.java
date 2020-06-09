package com.time.time.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.time.time.model.Login;


public interface LoginService extends IService<Login> {
     Login queryByKey(String userName);
     Integer     addNews(Login login);
}
