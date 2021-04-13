package com.qq.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author qq
 * @Package com.qq.test
 * @date 2021/4/8 11:40
 */
public class StringTest {
    public static void main(String[] args) {
        Lock re = new ReentrantLock();
        re.lock();
        String s = "123";
        String b = "231";
        helper(s,b);
        /*System.out.println(s.compareTo("124"));
        System.out.println(s.compareTo("123"));
        System.out.println(s.compareTo("122"));
        StringBuilder sb =new StringBuilder(s);
        System.out.println(s.substring(0,1));
        System.out.println(sb.delete(sb.length()-1,sb.length()));*/
    }
    public static void helper(String a, String b){
        String s = a.substring(1,a.length()) + a.substring(0,1);
        String kk = "231";
        System.out.println(s==b);
        System.out.println(kk==b);
        System.out.println("23"==a.substring(1,a.length()));
        System.out.println(s.equals(b));
    }
}
