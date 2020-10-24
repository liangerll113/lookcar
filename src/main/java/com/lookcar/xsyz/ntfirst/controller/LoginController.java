package com.lookcar.xsyz.ntfirst.controller;

import com.alibaba.druid.util.StringUtils;
import com.lookcar.xsyz.ntfirst.context.UserContext;
import com.lookcar.xsyz.ntfirst.enumresponse.ResponseEnum;
import com.lookcar.xsyz.ntfirst.form.LoginForm;
import com.lookcar.xsyz.ntfirst.service.FtUserService;
import com.lookcar.xsyz.ntfirst.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/login")
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private FtUserService ftUserService;

    @PostMapping
    public Map<String, Object> login(@RequestBody LoginForm loginForm) {
        if (StringUtils.isEmpty(loginForm.getUserName()) || StringUtils.isEmpty(loginForm.getPassWord())) {
            return ResponseUtil.getResponseData(ResponseEnum.PARAMS_NULL);
        }

        if (ftUserService.validPassword(loginForm.getUserName(), loginForm.getPassWord()) == 0) {
            logger.warn("valid password error, username = {}", loginForm.getUserName());
            return ResponseUtil.getResponseData(ResponseEnum.ACCOUNT_OR_PASSWORD_ERROR);
        }

        logger.info("login success, username = {}", loginForm.getUserName());
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        UserContext.setToken(token, loginForm.getUserName());
        return ResponseUtil.getSuccessResult(token);
    }

}
