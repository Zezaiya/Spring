package com.Zezai;

import com.Zezai.config.SpringConfig;
import com.Zezai.dao.Dao;
import com.Zezai.dao.impl.bookDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AOP {
    //    1.导入坐标
    //    2.准备好原始方法
    //    3.制作通知与通知类
    //    4.定义切入点
    //    5.定义切面
    public static void main(String[] args) {
        ApplicationContext atx=new AnnotationConfigApplicationContext(SpringConfig.class);
        Dao dao=atx.getBean(bookDaoImpl.class);
        dao.daoAction2(22,"Zezai");
    }
}
