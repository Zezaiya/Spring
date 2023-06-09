package com.Zezai.dao;

import com.Zezai.domain.Brand;
import com.Zezai.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface Dao {
    @Select("select * from tb_brand")
    List<Brand> selectAll();

    void daoAction();

    void daoAction2(int age,String name);

    int daoAction3();

    void daoAction4();
    @Select("select * from user where username=#{username} and password=#{password}")
    User CodeCheck(@Param("username") String username, @Param("password") String password);

    @Select("select leftMoney from user where username=#{username}")
    int CheckLeftMoney( String username);

    @Update("update user set leftMoney=leftMoney-#{lost} where username=#{username}")
    boolean outMoney(@Param("username")String username,@Param("lost")int lost);

    @Update("update user set leftMoney=leftMoney+#{lost} where username=#{OPusername}")
    boolean inMoney(@Param("OPusername") String OPusername,@Param("lost") int lost);

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Insert("insert into log(`id`,`info`,`金额`,`time`) values(null,#{info},#{lost},now())")
    void addLog(@Param("info")String info, @Param("lost")int lost, @Param("time") Date time);
}
