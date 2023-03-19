package com.Zezai;

import com.Zezai.config.SpringConfig;
import com.Zezai.domain.Brand;
import com.Zezai.service.Service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.List;
@Configuration
public class MybatisForSpring {
    public static void main(String[] args) {
        ApplicationContext atx=new AnnotationConfigApplicationContext(SpringConfig.class);
        Service service=(Service) atx.getBean("ServiceImpl");
        List<Brand> brandInfo=service.selectAll();
        System.out.println(brandInfo);
    }
}
