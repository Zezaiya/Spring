package com.Zezai;

import com.Zezai.service.Impl.bookServiceImpl;
import com.Zezai.config.SpringConfig;
import com.Zezai.domain.Brand;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MybatisForSpring {
    public static void main(String[] args) {
        ApplicationContext atx=new AnnotationConfigApplicationContext(SpringConfig.class);
        bookServiceImpl service=(bookServiceImpl)atx.getBean("bookServiceImpl");
        List<Brand> brandInfo=service.selectAll();
        System.out.println(brandInfo);
    }
}
