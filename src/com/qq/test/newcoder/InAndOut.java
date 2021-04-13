package com.qq.test.newcoder;

import org.omg.PortableInterceptor.USER_EXCEPTION;
import sun.nio.cs.CharsetMapping;

import javax.jws.soap.SOAPBinding;
import javax.print.DocFlavor;
import javax.swing.text.html.HTMLDocument;
import java.lang.reflect.Array;
import java.util.*;

/**
 * @author qq
 * @Package PACKAGE_NAME
 * @date 2021/3/31 21:33
 */
public class InAndOut {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 从键盘接收数据
        // nextLine方式接收字符串
        //System.out.println("nextLine方式接收：");
        // 判断是否还有输入
        //StringBuilder sb =  new StringBuilder();
        List<User> st = new ArrayList<>();
        Map<String, User> hashMap = new HashMap<>();
        while (scan.hasNextLine()) {
            String str2 = scan.nextLine();
            String[] temp = str2.split(" ");
            if (temp.length > 1) {
                String[] name = temp[0].split("-");
                String[] number = temp[1].split(":");
                int num0 = Integer.valueOf(number[0]);
                int num1 = Integer.valueOf(number[1]);

                if (!hashMap.containsKey(name[0])) {
                    User user1 = new User(name[0], 0);
                    hashMap.put(name[0], user1);
                    st.add(user1);
                }
                if (!hashMap.containsKey(name[1])) {
                    User user2 = new User(name[1], 0);
                    hashMap.put(name[1], user2);
                    st.add(user2);
                }

                if (num0 > num1) {
                    hashMap.get(name[0]).win(3);
                } else if (num0 < num1) {
                    hashMap.get(name[1]).win(3);
                } else {
                    hashMap.get(name[0]).win(1);
                    hashMap.get(name[1]).win(1);
                }
            }

            if ("".equals(str2)) break;
        }
        //sort 定义比较器 返回负数 则第一个参数在前面  所以写成v2-v1就成了降序
        Collections.sort(st, (v1, v2) -> {
            if (v2.getNumber() == v1.getNumber())
                return v1.getName().compareTo(v2.getName());
            return v2.getNumber() - v1.getNumber();
        });
        for (int i = 0; i < st.size(); i++) {
            if (i == (st.size() - 1)) {
                System.out.print(st.get(i).getName() + " " + st.get(i).getNumber());
                break;


            }
            System.out.print(st.get(i).getName() + " " + st.get(i).getNumber() + ",");
        }
        System.out.println(st);

        Iterator<Map.Entry<String, User>> it = hashMap.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String,User> temp = it.next();
            System.out.println("entrySet"+temp.getKey()+"    "+temp.getValue());
        }
        Iterator<String> it1 = hashMap.keySet().iterator();
        while(it1.hasNext()){
            String temp = it1.next();
            System.out.println("keySet"+hashMap.get(temp));
        }
        Set<String> it2 = hashMap.keySet();

        Set<Map.Entry<String,User>> s = hashMap.entrySet();
        hashMap.forEach((v1,v2)->{
            System.out.println("forEach"+v1+v2);
        });



        scan.close();
    }
    static class User {
        private String name;
        private int number;


        public User(String name, int number) {
            this.name = name;
            this.number = number;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public void win(int number) {
            this.number += number;
        }
        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", number=" + number +
                    '}';
        }
    }
}
