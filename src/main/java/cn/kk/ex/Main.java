package cn.kk.ex;

import cn.kk.factory.ServiceFactory;

/**
 * 通过注解中的value不同获取不同的对象
 * Created by sunxikai on 18/6/13.
 */
public class Main {
    public static void main(String[] args) {
        // 获取单例对象
        ServiceFactory.singletonMyLean().lean();
        ServiceFactory.singletonMyLean("MyLean2").lean();

        //每次获取的对象地址不同
        System.out.println(ServiceFactory.newMyLean("MyLean1"));
        System.out.println(ServiceFactory.newMyLean("MyLean1"));

    }
}
