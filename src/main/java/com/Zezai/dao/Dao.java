package com.Zezai.dao;

import com.Zezai.domain.Brand;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface Dao {
    @Select("select * from tb_brand")
    List<Brand> selectAll();

    void daoAction();

    void daoAction2(int age,String name);

    int daoAction3();

    void daoAction4();

    boolean CodeCheck(String username,String password);
}
