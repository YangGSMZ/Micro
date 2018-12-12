package com.micro.hospital.service.Impl;

import org.springframework.stereotype.Service;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoServiceI {
    public boolean login(String username, String password, String confirmPassword){
        return (username.equals("chhliu") && password.equals("123456") && confirmPassword.equals("123456"));
    }
}
