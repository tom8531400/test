package org.example;

import java.io.IOException;

public class leetcode1 {
    public static void main(String[] args) throws IOException, InterruptedException {
        // 車貸 一個月11459  還需還8個月 91672元
        // 學貸 一個月3460 還須還4個月 17300元
        // 信貸 一個月3516 還須還 115196元
        // 週六 一個月1000 還須環36000元
        // 卡費 還須環50000元
        System.out.println(91672 + 17300 + 115196 + 36000 + 50000);

        // 1萬 250月息
        // 20萬
        System.out.println(250 * 20);
    }
}