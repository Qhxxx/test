package com.qq.test.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

/**
 * @author qq
 * @Package com.qq.test.nio
 * @date 2021/4/27 21:38
 */
public class Client {
    public static void main(String[] args) {

        new Thread(()->{
            client("A");
        },"A").start();

        new Thread(()->{

            client("B");
        },"B").start();

        new Thread(()->{

            client("C");
            },"c").start();
    }


    public static void client(String name){
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        SocketChannel socketChannel = null;
        try
        {
            TimeUnit.SECONDS.sleep(1);
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);

            socketChannel.connect(new InetSocketAddress("192.168.2.108",8080));
            if(socketChannel.finishConnect())
            {
                int i=0;
                while(true)
                {
                    TimeUnit.SECONDS.sleep(1);
                    String info = name + ": I'm "+i+++"-th information from client";
                    buffer.clear();
                    buffer.put(info.getBytes());
                    buffer.flip();
                    while(buffer.hasRemaining()){
                        System.out.println(buffer);
                        socketChannel.write(buffer);
                    }
                }
            }
        }
        catch (IOException | InterruptedException e)
        {
            e.printStackTrace();
        }
        finally{
            try{
                if(socketChannel!=null){
                    socketChannel.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
