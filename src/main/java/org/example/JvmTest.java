package org.example;


import java.util.Arrays;
import java.util.LinkedList;

public class JvmTest {
    public static void main(String[] args) {
        int[] data = new int[]{10, 20, 5, 3, 56, 8, 32, 4, 13, 7};
        JvmTest jvmTest = new JvmTest();
        Arrays.stream(jvmTest.method1(data)).forEach(System.out::println);
    }

    // 選擇排序
    public int[] method1(int[] data) {
        for (int j = 0; j < data.length; j++) {
            for (int i = j + 1; i < data.length; i++) {
                if (data[j] > data[i]) {
                    int temp = data[j];
                    data[j] = data[i];
                    data[i] = temp;

                }
            }
        }
        return data;
    }

    // 冒泡排序
    public int[] method2(int[] data) {
        int num = 1;
        boolean flag = true;
        for (int j = 0; j < data.length; j++) {
            for (int i = 0; i < data.length - num; i++) {
                if (data[i] > data[i + 1]) {
                    int temp = data[i];
                    data[i] = data[i + 1];
                    data[i + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
            num++;
            flag = true;
        }
        return data;
    }

}