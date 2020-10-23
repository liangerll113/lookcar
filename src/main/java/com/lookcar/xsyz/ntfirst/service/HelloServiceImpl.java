package com.lookcar.xsyz.ntfirst.service;

import com.lookcar.xsyz.ntfirst.dao.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public String getName() {
        return testMapper.getName();
    }

    @Override
    public String getNameById(int id) {
        return testMapper.getNameById(id);
    }

}
