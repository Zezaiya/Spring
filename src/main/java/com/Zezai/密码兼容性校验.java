package com.Zezai;

import com.Zezai.config.SpringConfig;
import com.Zezai.domain.User;
import com.Zezai.service.Service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class 密码兼容性校验 {
    //有的用户在界面输入账号密码时可能会加上空格,如果后台不进行处理会影响到用户体验
    //思路:当用户的密码传入后台时(这里就不用Servlet了,模拟直接到Service层),在Service层接收参数之前通过环绕通知的方式对传入的参数进行处理,
    //     将空白符去除后再传入原方法中
    public static void main(String[] args) {
        ApplicationContext atx=new AnnotationConfigApplicationContext(SpringConfig.class);
        Service service=atx.getBean(Service.class);
        User user=new User();
        user.setUsername("123456");
        user.setPassword("zezaiya6 ");
        System.out.println(service.CodeCheckService(user.username,user.password));
    }
}
