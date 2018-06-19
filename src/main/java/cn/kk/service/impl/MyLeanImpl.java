package cn.kk.service.impl;

import cn.kk.annotation.SPI;
import cn.kk.service.MyLean;

/**
 * 实现类1
 * Created by sunxikai on 18/6/13.
 */
@SPI(value="MyLean1")
public class MyLeanImpl implements MyLean {
    @Override
    public void lean() {
        System.out.println("实现类1:[" + this.getClass().getName() + "]");
    }
}
