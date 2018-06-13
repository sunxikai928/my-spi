package cn.kk.factory;

import cn.kk.service.MyLean;
import cn.kk.service.impl.MyLeanImpl;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Created by sunxikai on 18/6/13.
 */
public class ServiceFactory {

    private ServiceFactory() {
    }

    public static MyLean newMyLean() {
        ServiceLoader<MyLean> serviceLoader = ServiceLoader.load(MyLean.class);
        Iterator<MyLean> myLeanIterator = serviceLoader.iterator();
        // 这里是直接取第一个
        while (myLeanIterator.hasNext()) {
            MyLean myLean = myLeanIterator.next();
            // 这里可以通过判断类型获得具体类型的实现,如果需要实现单例可以在工厂中缓存
            if (myLean.getClass() == MyLeanImpl.class) {
                return myLean;
            }

            // 这里直接取第一个
//            if (myLean != null) {
//                return myLean;
//            }
        }
        return null;
    }

}
