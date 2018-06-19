package cn.kk.annotation;

import java.lang.annotation.*;

/**
 *
 * Created by sunxikai on 18/6/19.
 */
@Target({ElementType.TYPE}) //注解的作用目标 接口、类、枚举、注解
@Retention(RetentionPolicy.RUNTIME) // 注解会在class字节码文件中存在，在运行时可以通过反射获取到
@Documented//说明该注解将被包含在javadoc中
public @interface SPI {
    String value() default "old";
}
