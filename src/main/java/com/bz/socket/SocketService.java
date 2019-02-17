package com.bz.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 基于TCP协议的Socket通信，实现用户登录，服务端
 */
public class SocketService {

    private static final int port = 3344;

    public static void main(String[] args) throws IOException {
        //1、创建一个服务器端Socket，即ServerSocket，指定绑定的端口，并监听此端口
        ServerSocket serverSocket = new ServerSocket(port);
        //2、调用accept()方法开始监听，等待客户端的连接
        Socket socket = serverSocket.accept();

        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String info = null;
        while((info=br.readLine())!=null){
            System.out.println("我是服务端，客户端说:" + info);
        }

        OutputStream os = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(os);
        pw.write("欢迎您！");
        pw.flush();

        socket.shutdownInput();

        br.close();
        is.close();
        os.close();
        pw.close();
        socket.close();
        serverSocket.close();
    }

}
