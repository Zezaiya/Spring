package com.Zezai;

import com.Zezai.config.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class 纯注解开发 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfig.class);
        DataSource dataSource= ctx.getBean(DataSource.class);
        System.out.println(dataSource);

        ctx.close();
    }
}
