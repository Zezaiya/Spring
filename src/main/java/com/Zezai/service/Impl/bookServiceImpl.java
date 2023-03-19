package com.Zezai.service.Impl;

import com.Zezai.dao.Dao;
import com.Zezai.domain.Brand;
import com.Zezai.service.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Service("ServiceImpl")//设置这个类为bean类，取名为bookServiceImpl
@ComponentScan("com.Zezai")//光设置类不行，必须让容器能找到该bean，所以要添加扫描仪
@Scope("prototype")
public class bookServiceImpl implements Service {
    @Resource
    private Dao dao; //通过new的方式耦合度仍然很高,所以我们需要通过方法来创建对象
    @Value("${number}")
    public int number;
    @Value("${name}")
    public String name;
    @Override
    public boolean CodeCheckService(String username, String password) {
        if(dao.CodeCheck(username, password)!=null)
        {
            return true;
        }
        else
            return false;
    }


    //提供对应的set方法,IoC会通过我们写的配置文件<property name="Dao" ref="DaoImpl"></property>,自动将对应的实现类对象daoImpl传入dao内
    //注意:set方法其实在创建容器时就会被调用,所以我们从容器中取出来的service对象其实里面就已经帮我们自动获取了daoImpl这个对象
    /*public void setDao(Dao dao) {
        this.dao = dao;
    }*/
    void bookServiceImpl(){};
    public List<Brand> selectAll(){
        List<Brand> brandInfo=dao.selectAll();
        return brandInfo;
    }

    @Override
    public int ServiceCheckLeftMoney(String username) {
        System.out.println(dao.CheckLeftMoney(username));
       return dao.CheckLeftMoney(username);
    }

    @Override
    public void ServiceTransfer(String username,String OPusername,int lost) {
        Date time=new Date();
        String info= "转账操作:"+username+"->"+OPusername;
        try {
            dao.inMoney(OPusername,lost);
            //如果在转账操作中间出现异常,会导致账户金额出现异常,所以这个时候需要用到事务处理
            dao.outMoney(username,lost);
        }finally {
            dao.addLog(info,lost,time);
        }

        System.out.println("转账成功!");

    }


    /*@PostConstruct
    public void afterPropertiesSet() {
        System.out.println("init.....");
    }
    @PreDestroy
    public void destroy() {
        System.out.println("destroy.....");
    }*/



}

