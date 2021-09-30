package com.Socket.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class NioSelectorServer {
    public static void main(String[] args) throws IOException {
        //创建NIO ServerSocketChannel
        ServerSocketChannel serverSocket = ServerSocketChannel.open();
        serverSocket.socket().bind(new InetSocketAddress(9000));
        //设置非阻塞
        serverSocket.configureBlocking(false);
        //打开selector
        Selector selector = Selector.open();
        //把serverSocketChannel注册到selector上
        SelectionKey selectionKey = serverSocket.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("服务启动成功");

        while (true){
            //阻塞等待需要处理的事件发生
            selector.select();

        }
    }
}
