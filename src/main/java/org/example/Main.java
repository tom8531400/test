package org.example;

import com.sun.xml.internal.ws.util.StringUtils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // 我目前星耀5 四顆星  五場大概贏 三場
        // System.out.println((int)method2(Type.Star_Glory.num, 5, 4, 3) + "小時");
        String s = null;


    }

    /**
     * 計算上璀璨傳說需要多久
     *
     * @param star   目前牌位
     * @param starNum 目前位階 例:星耀 後面數字
     * @param num    目前已有幾顆星
     * @param winNum 大概五場能贏幾場
     * @return 要花幾小時
     */
    public static double method2(int star, int starNum, int num, int winNum) {
        // 計算離傳說還需要幾顆星 上一等級需要5階一階5顆星
        int data = ((Type.Legend.num - star) * starNum * 5);
        // 扣掉已有的星星數 + 璀璨需要的50顆星
        int end = data - num + 50;
        // 用勝率來添加所需星星數 (一場大概20分鐘)
        return (double) (end / ((double)winNum / 5) * 20) / 60;
    }
}

enum Type {
    Bronze(1),
    Silver(2),
    Gold(3),
    Platinum(4),
    Diamond(5),
    Star_Glory(6),
    Legend(7);

    final int num;

    Type(int num) {
        this.num = num;
    }

}

