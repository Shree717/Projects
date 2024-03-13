package com.Spring.service;

import com.Spring.dto.UserDto;
import com.Spring.model.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);
    User findUserByEmail(String email);

}
