package com.Zezai.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration  //表示这个类就是配置类
@ComponentScan("com.Zezai")   //表示添加了注释扫描器,可以扫描com.Zezai包下的所有注释
@PropertySource("jdbc.properties")//引用了资源包，表示项目里的${}键里的值会从这里查找
@Import({JdbcConfig.class,MybatisConfig.class})  //目的是在不写入SpringConfig类里前提下,实现第三方(druid)bean配置以及获取工厂对象
//@EnableAspectJAutoProxy//告诉Spring里面含有注解开发的内容,启动@Aspect(AOP)自动代理
public class SpringConfig {
}
