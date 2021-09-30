package com.Socket.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class NioServer {
    static List<SocketChannel> channelList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        //创建NIO
        ServerSocketChannel serverSocket = ServerSocketChannel.open();
        serverSocket.socket().bind(new InetSocketAddress(9000));
        System.out.println("服务启动");


        while(true){
            //NIO的非阻塞是由操作系统实现的，底层调用了linux内核的accept函数
            SocketChannel socketChannel = serverSocket.accept();
            if(socketChannel != null){
                System.out.println("连接成功");
                //设置SocketChannel为非阻塞
                socketChannel.configureBlocking(false);
                channelList.add(socketChannel);
            }
            //遍历读取数据
            Iterator<SocketChannel> iterator = channelList.iterator();
            while(iterator.hasNext()){
                SocketChannel sc = iterator.next();
                ByteBuffer byteBuffer = ByteBuffer.allocate(128);
                //非阻塞模式read方法不会阻塞，否则会阻塞
                int len = sc.read(byteBuffer);
                //如果有数据就把数据打印出来
                if(len>0){
                    System.out.println("接收到消息："+new String(byteBuffer.array()));
                } else if(len==-1){ //如果客户端断开链接，就把socket从集合中去掉
                    iterator.remove();
                    System.out.println("客户端断开链接");
                }
            }
        }
    }
}
