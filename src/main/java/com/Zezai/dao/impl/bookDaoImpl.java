package com.Zezai.dao.impl;

import com.Zezai.dao.Dao;
import com.Zezai.domain.Brand;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("DaoImpl")
public class bookDaoImpl implements Dao {

    public List<Brand> selectAll() {
        return null;
    }

    // @Override
    public void daoAction() {
        System.out.println("dao Action");
    }

    //@Override
    public void daoAction2(int age,String name) {
        System.out.println(name+" is "+age+" years old" );
    }

    // @Override
    public int daoAction3() {
        System.out.println("dao Action3");
        return 666;
    }public void daoAction4() {
        System.out.println("dao Action4");
    }

    @Override
    public boolean CodeCheck(String username, String password) {
        String CurUsername="123456";
        String CurPassword="zezaiya6";
        return username.equals(CurUsername) && password.equals(CurPassword);
    }


}
