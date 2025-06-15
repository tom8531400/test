package org.example;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Text {
    public static void main(String[] args) throws Exception {
        RandomAccessFile randomAccessFile = null;
        try{
            randomAccessFile = new RandomAccessFile("wen.txt", "rw");
            FileChannel channel = randomAccessFile.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            int len = channel.read(byteBuffer);
            if(len != -1){
                System.out.println(new String(byteBuffer.array(), 0, len));
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }finally {
            if(randomAccessFile != null) randomAccessFile.close();
        }
    }
}
