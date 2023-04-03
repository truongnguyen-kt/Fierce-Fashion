package com.mtlt.service;

import com.mtlt.entity.usersEntity;

public interface usersService {
    String addNewUser(usersEntity user);
    usersEntity checkLogin(String id, String password);
}
