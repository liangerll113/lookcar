package com.lookcar.xsyz.ntfirst.service.impl;

import com.lookcar.xsyz.ntfirst.dao.FtUserMapper;
import com.lookcar.xsyz.ntfirst.service.FtUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FtUserServiceImpl implements FtUserService {

    @Autowired
    private FtUserMapper ftUserMapper;

    @Override
    public int validPassword(String username, String password) {
        return ftUserMapper.validPassword(username, password);
    }
}
