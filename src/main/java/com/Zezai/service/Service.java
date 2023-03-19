package com.Zezai.service;

import com.Zezai.domain.Brand;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

public interface Service {

    boolean CodeCheckService(String username, String password);

    public List<Brand> selectAll();

    int ServiceCheckLeftMoney(String username);

     @Transactional(rollbackFor = IOException.class)   //并不是遇到所有的异常事物都会回滚,所以我们要将那些特例的异常指定出来回滚
    void ServiceTransfer(String username,String OPusername,int lost);


}
