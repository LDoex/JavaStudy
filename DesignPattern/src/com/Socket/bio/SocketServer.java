package com.Socket.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        while(true){
            System.out.println("等待连接");
            Socket clientSocket = serverSocket.accept();
            System.out.println("有客户端连接了");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        SocketHandler socketHandler = new SocketHandler();
                        socketHandler.handler(clientSocket);
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
