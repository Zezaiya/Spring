package com.Zezai.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class MybatisConfig {
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {//SqlSessionFactoryBeans是mybatis为整合Spring提供的一个类，可以快速获取工厂对象
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setTypeAliasesPackage("com.Zezai.domain");
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;//这个方法仅能创造工厂，但获取不了mapper对象，所以需要再造一个类
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.Zezai.dao");//MapperScannerConfigurer会扫描这个包中的所有接口，
        return mapperScannerConfigurer;                         //把每个接口都执行一次getMapper方法，得到每个接口的dao对象,
        //把创建好的dao对象放入到spring的容器中

    }
}
