package com.bz.socket;

import java.io.*;
import java.net.Socket;

public class SocketClient {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 3344);
        OutputStream os = socket.getOutputStream();

        PrintWriter pw = new PrintWriter(os);
        pw.write("aaaaaaaaa");
        pw.flush();
        socket.shutdownOutput();

        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String info = null;
        while((info=br.readLine())!=null){
            System.out.println("我是客户端，服务器说："+info);
        }

         //4、关闭资源
         br.close();
         is.close();
         pw.close();
         os.close();
         socket.close();

    }

}
