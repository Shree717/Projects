package com.Login.service;

import com.Login.model.User;
import com.Login.model.UserDto;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);
    User findUserByEmail(String email);
    List<UserDto> findAllUsers();
}
