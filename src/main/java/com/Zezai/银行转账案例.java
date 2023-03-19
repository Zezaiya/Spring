package com.Zezai;

import com.Zezai.config.SpringConfig;
import com.Zezai.service.Service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class 银行转账案例 {
    public static void main(String[] args) {
        ApplicationContext atx=new AnnotationConfigApplicationContext(SpringConfig.class);
        Service service= atx.getBean(Service.class);
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入你的账号:");
        String username=scanner.next();
        System.out.println("请输入你的密码:");
        String password=scanner.next();
        if(service.CodeCheckService(username,password)) {
            System.out.println("登录成功,请选择您的业务");
            System.out.println("1------------查询余额");
            System.out.println("2------------向对方转账");
            int input = scanner.nextInt();
            if (input == 1) {
                service.ServiceCheckLeftMoney(username);
            } else
                System.out.println("请输入转账对象账号:");
            String OPusername = scanner.next();
            System.out.println("请输入转账的金额");
            service.ServiceTransfer(username, OPusername, scanner.nextInt());
        }
        else
            System.out.println("账号或密码错误");
    }
}
