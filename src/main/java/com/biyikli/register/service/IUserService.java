package com.biyikli.register.service;

import com.biyikli.register.dto.UserDto;
import com.biyikli.register.entity.User;

public interface IUserService {

    public User registerUser(UserDto userDto);
}
