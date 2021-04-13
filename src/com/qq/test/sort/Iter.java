package com.qq.test.sort;

/**
 * @author qq
 * @Package com.qq.test.sort
 * @date 2021/4/12 22:26
 */
public interface Iter {

    default void eat(){
        //有构造方法  子类初始化的时候会调用
        //没有构造方法
        //可以有方法的实现，接口方法的实现必须定义为default
        //成员变量只能是static final 而且必须赋值
    }

}
