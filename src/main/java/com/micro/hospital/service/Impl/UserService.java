package com.micro.hospital.service.Impl;

import com.micro.hospital.bean.DataSource;
import com.micro.hospital.bean.UserBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

@Component
public class UserService {
    public UserBean getUser(String username) {
        // 没有此用户直接返回null
        if (! DataSource.getData().containsKey(username))
            return null;

        UserBean user = new UserBean();
        Map<String, String> detail = DataSource.getData().get(username);

        user.setUsername(username);
        user.setPassword(detail.get("password"));
        user.setRole(detail.get("role"));
        user.setPermission(detail.get("permission"));
        return user;
    }
}
