package com.Zezai.config;

import com.Zezai.dao.impl.bookDaoImpl;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class JdbcConfig {
    //1.定义一个方法获得要管理的对象
    //2.添加@Bean标签,表示当前方法返回的是Bean类型
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;
    @Bean//方法显示未被调用只是因为我们未主动调用，在启动项目后容器会自动扫描bean标签并调用该方法获取到对象
    public DataSource dataSource(bookDaoImpl bookDao){   //容器扫描bean标签后，会查看方法是否有参数，如果有会从自己的容器里找到相应的对象填入
        DruidDataSource ds=new DruidDataSource();
        ds.setDriverClassName(driver);//直接写会提高耦合性，所以先定义对应的成员变量
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        return ds;
    }
}
