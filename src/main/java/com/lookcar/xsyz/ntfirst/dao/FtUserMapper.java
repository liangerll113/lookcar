package com.lookcar.xsyz.ntfirst.dao;

import com.lookcar.xsyz.ntfirst.entity.FtUser;

public interface FtUserMapper {

    int createUser(FtUser ftUser);

    int validPassword(String username, String password);
}
