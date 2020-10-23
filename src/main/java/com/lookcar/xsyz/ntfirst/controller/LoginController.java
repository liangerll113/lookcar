package com.lookcar.xsyz.ntfirst.controller;

import com.lookcar.xsyz.ntfirst.context.UserContext;
import com.lookcar.xsyz.ntfirst.enumresponse.ResponseEnum;
import com.lookcar.xsyz.ntfirst.form.LoginForm;
import com.lookcar.xsyz.ntfirst.util.ResponseUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/login")
public class LoginController {

    @PostMapping
    public Map<String, Object> login(@RequestBody LoginForm loginForm) {
        if ("admin".equals(loginForm.getUserName()) && "123456".equals(loginForm.getPassWord())) {
            String token = UUID.randomUUID().toString().replaceAll("-", "");
            UserContext.setToken(token, loginForm.getUserName());
            return ResponseUtil.getSuccessResult(token);
        }
        return ResponseUtil.getResponseData(ResponseEnum.PARAMS_NULL);
    }

}
