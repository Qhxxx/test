package com.qq.test.newcoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author qq
 * @Package com.qq.test.newcoder
 * @date 2021/4/4 10:50
 */
public class IPnet {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            if(s == null || s.length()==0||s1==null||s1.length()==0||s2==null||s2.length()==0){
                System.out.println(1);
                continue;
            }



            String[] ss = s.split("\\.");//转义
            String[] ss1 = s1.split("\\.");
            String[] ss2 = s2.split("\\.");
            if(!flag(ss)||!flag(ss1)||!flag(ss2)){
                System.out.println(1);
                continue;
            }
            boolean flag = false;
            for(int i = 0; i < ss.length; ++i){
                int n = Integer.valueOf(ss[i]);
                int n1 = Integer.valueOf(ss1[i]);
                int n2 = Integer.valueOf(ss2[i]);
                System.out.println(Integer.toBinaryString(n));
                System.out.println(Integer.toBinaryString(n1));
                System.out.println(Integer.toBinaryString(n2));
                if((n & n1) == (n & n2)){
                    flag = true;
                }else{
                    flag = false;
                    break;
                }
            }
            if(flag)System.out.println(0);
            else System.out.println(2);
        }
    }
    public static boolean flag(String[] s){

        int len = s.length;
        System.out.println("len"+len);
        if(len != 4)return false;
        for(int i = 0; i < len; ++i){
            int temp = Integer.valueOf(s[i]);
            if(temp<0||temp>255){
                return false;
            }
        }
        return true;
    }
}
