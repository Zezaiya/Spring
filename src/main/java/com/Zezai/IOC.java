package com.Zezai;

import com.Zezai.config.SpringConfig;
import com.Zezai.dao.Dao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOC {
    public static void main(String[] args) {
        //获取容器
        AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfig.class);
        //Dao dao=(Dao)ctx.getBean("DaoImpl");
        //获取Bean
        Dao dao=(Dao) ctx.getBean("bookDaoImpl");
        //DataSource dataSource=(DataSource)ctx.getBean("dataSource");
        System.out.println(dao);
        // service.serviceAction();
        //ctx.close();暴力的方式
        ctx.registerShutdownHook();
     /* Service service=new ServiceImpl();
      service.serviceAction();*/
    }
}
