package cn.kk.factory;

import cn.kk.annotation.SPI;
import cn.kk.service.MyLean;

import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 根据参数的不同每次获取不同的对象
 * Created by sunxikai on 18/6/13.
 */
public class ServiceFactory {

    private static Map<String, Object> map = new ConcurrentHashMap<>();

    private ServiceFactory() {
    }

    /**
     * 获取单例对象
     *
     * @return
     */
    public static synchronized MyLean singletonMyLean() {
        return newMyLean("MyLean1");
    }

    public static synchronized MyLean singletonMyLean(String className) {
        if (map.containsKey(className))
            return (MyLean) map.get(className);

        ServiceLoader<MyLean> serviceLoader = ServiceLoader.load(MyLean.class);
        Iterator<MyLean> myLeanIterator = serviceLoader.iterator();
        // 将所有对象放入
        while (myLeanIterator.hasNext()) {
            MyLean myLean = myLeanIterator.next();
            // 这里可以通过判断类型获得具体类型的实现,如果需要实现单例可以在工厂中缓存
            Annotation[] annotations = myLean.getClass().getAnnotations();
            for (int i = 0; i < annotations.length; i++) {
                Annotation a = annotations[i];
                if (a.annotationType() == SPI.class) {
                    SPI spi = (SPI) a;
                    if (spi.value().equals(className)) {
                        map.put(className, myLean);
                    }
                }
            }
        }
        return (MyLean) map.get(className);
    }

    /**
     * 每次获取新的对象
     *
     * @return
     */
    public static synchronized MyLean newMyLean() {
        return newMyLean("MyLean1");
    }

    public static synchronized MyLean newMyLean(String className) {
        ServiceLoader<MyLean> serviceLoader = ServiceLoader.load(MyLean.class);
        Iterator<MyLean> myLeanIterator = serviceLoader.iterator();
        // 将所有对象放入
        while (myLeanIterator.hasNext()) {
            MyLean myLean = myLeanIterator.next();
            // 这里可以通过判断类型获得具体类型的实现,如果需要实现单例可以在工厂中缓存
            Annotation[] annotations = myLean.getClass().getAnnotations();
            for (int i = 0; i < annotations.length; i++) {
                Annotation a = annotations[i];
                if (a.annotationType() == SPI.class) {
                    SPI spi = (SPI) a;
                    if (spi.value().equals(className)) {
                        return myLean;
                    }
                }
            }
        }
        return (MyLean) null;
    }

}
