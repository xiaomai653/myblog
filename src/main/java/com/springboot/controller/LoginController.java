package com.springboot.controller;


import com.springboot.config.Result;
import com.springboot.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        if (StringUtils.equals("admin", user.getUsername()) && StringUtils.equals("123456", user.getPassword())){
            return Result.success(user);
        }
        return Result.fail();
    }
}
