package com.Socket.bio;

import java.io.IOException;
import java.net.Socket;

public class SocketHandler {
    public void handler(Socket clientSocket) throws IOException {
        byte[] bytes = new byte[1024];
        System.out.println("准备读数据");
        //接受客户端数据，没有数据可读时就阻塞
        int read = clientSocket.getInputStream().read(bytes);
        System.out.println("读完了");
        if (read != -1) {
            System.out.println("接受到数据：" + new String(bytes, 0, read));
        }
    }
}
