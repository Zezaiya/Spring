package com.Zezai.service;

import com.Zezai.domain.Brand;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface Service {

    boolean CodeCheckService(String username, String password);

    public List<Brand> selectAll();

    int ServiceCheckLeftMoney(String username);
     @Transactional
    void ServiceTransfer(String username,String OPusername,int lost);
}
