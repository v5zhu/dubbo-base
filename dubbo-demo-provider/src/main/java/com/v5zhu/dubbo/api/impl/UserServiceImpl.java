package com.v5zhu.dubbo.api.impl;


import com.v5zhu.dubbo.api.UserService;
import com.v5zhu.dubbo.dto.UserDto;

/**
 * Created by zhuxl@paxsz.com on 2016/7/25.
 */
public class UserServiceImpl implements UserService {
    public UserDto findByLoginName(String loginName) {
        UserDto userDto=new UserDto();
        userDto.setId(1L);
        userDto.setLoginName(loginName);
        userDto.setPassword(loginName.toUpperCase());
        return userDto;
    }
}
