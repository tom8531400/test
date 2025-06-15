package org.example;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;

/**
 * 服務器端
 */
public class NioServer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = null;
        Selector selector = null;
        try {
            serverSocketChannel = ServerSocketChannel.open();
            selector = Selector.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().bind(new InetSocketAddress(8080));
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            while (true) {
                System.out.println("等待事件觸發...");
                int select = selector.select();
                if (select == 0) continue;
                System.out.println("客戶端進入");
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                for (SelectionKey selectionKey : selectionKeys) {
                    handel(selectionKey);
                }
                selectionKeys.clear();
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            if (serverSocketChannel != null) serverSocketChannel.close();
            if (selector != null) selector.close();
        }
    }

    public static void handel(SelectionKey selectionKey) throws IOException {
        if (selectionKey.isAcceptable()) {
            try {
                System.out.println("接收到客戶端連線事件..");
                ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
                SocketChannel socketChannel = serverSocketChannel.accept();
                socketChannel.configureBlocking(false);
                socketChannel.register(selectionKey.selector(), SelectionKey.OP_READ);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        } else if (selectionKey.isReadable()) {
            try {
                System.out.println("接收到客戶端寫入事件..");
                SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                int len = socketChannel.read(byteBuffer);
                String data = "";
                if (len != -1) {
                    data = new String(byteBuffer.array(), 0, len);
                    System.out.println("客戶端訊息:" + data);
                } else {
                    System.out.println("客戶端沒訊息");
                }
                String message = "服務器端回復收到:" + data;
                ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
                socketChannel.write(buffer);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }
}
