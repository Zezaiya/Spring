package com.Zezai.dao.impl;

import com.Zezai.dao.Dao;
import com.Zezai.domain.Brand;
import com.Zezai.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("DaoImpl")
public class bookDaoImpl  {
    Dao dao;
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
    }
    public void daoAction4() {
        System.out.println("dao Action4");
    }


    public boolean CodeCheck(String username,String password) {
        User user1=new User();
        user1.setUsername("tangwenze");
        user1.setPassword("123456");
        User user2=new User();
        user2.setUsername("guokai");
        user2.setPassword("123456");
        return username.equals(user1.username) && password.equals(user1.password);
    }


    public int CheckLeftMoney(String username) {
        return  dao.CheckLeftMoney(username);   //执行
    }


    public boolean outMoney(String username,int lost) {
         return dao.outMoney(username,lost);
    }


    public boolean inMoney(String OPusername, int lost) {
        return dao.inMoney(OPusername,lost);
    }


}
