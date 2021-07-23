package com.shopping.user.service;

import com.shopping.user.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService{

	UserDto createUser(UserDto userDto);

	UserDto getUserDetailsByEmail(String email);

}
