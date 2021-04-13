package com.qq.test;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author qq
 * @Package com.qq.test
 * @date 2021/4/10 19:33
 */
public class AtomicTest {
    static AtomicStampedReference<Integer> a = new AtomicStampedReference<>(1,1);

    public static void main(String[] args) {
        new Thread(()->{
            int stamp = a.getStamp();
            System.out.println(stamp);

            a.compareAndSet(1,2,a.getStamp(),a.getStamp()+1);
            System.out.println(a.getStamp());
            System.out.println(a.compareAndSet(1,2,a.getStamp(),a.getStamp()+1));
            System.out.println(a.getStamp());
        },"a").start();
    }
}
