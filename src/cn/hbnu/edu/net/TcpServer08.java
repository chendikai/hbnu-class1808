package cn.hbnu.edu.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 陈迪凯
 * @date 2020-11-12 8:32
 */
public class TcpServer08 {
    public static void main(String[] args) {
        try {
            // 1、创建socket服务，并监听端口
            ServerSocket serverSocket = new ServerSocket(8888);

            while (true) {
                // 2、获取socket连接
                Socket socket = serverSocket.accept();

                // 创建线程，并启动线程
                new Thread(new TcpServer08Thread(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
