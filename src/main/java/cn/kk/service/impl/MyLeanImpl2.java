package cn.kk.service.impl;

import cn.kk.annotation.SPI;
import cn.kk.service.MyLean;

/**
 * 实现类2
 * Created by sunxikai on 18/6/13.
 */
@SPI(value="MyLean2")
public class MyLeanImpl2 implements MyLean {
    @Override
    public void lean() {
        System.out.println("实现类2:[" + this.getClass().getName() + "]");
    }
}
