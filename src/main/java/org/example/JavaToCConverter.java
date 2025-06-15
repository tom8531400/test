package org.example;

import java.util.Scanner;

public class JavaToCConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("請輸入 Java 程式碼（輸入 END 結束）：");

        StringBuilder javaCode = new StringBuilder();
        String line;
        while (!(line = scanner.nextLine()).equals("END")) {
            javaCode.append(line).append("\n");
        }

        String cCode = convertJavaToC(javaCode.toString());
        System.out.println("\n轉換後的 C 程式碼：\n");
        System.out.println(cCode);
    }

    public static String convertJavaToC(String javaCode) {
        // 最基本的規則：刪除 class、main 方法等等
        String cCode = javaCode;

        // 刪除 public class 開頭
        cCode = cCode.replaceAll("public\\s+class\\s+\\w+\\s*\\{", "");
        // 移除 public static void main 方法開頭
        cCode = cCode.replaceAll("public\\s+static\\s+void\\s+main\\(String\\[\\]\\s+args\\)\\s*\\{", "");
        // 移除 System.out.println
        cCode = cCode.replaceAll("System\\.out\\.println", "printf");
        // Java 結尾 ; 改為加上 \n（可選）
        cCode = cCode.replaceAll(";", ";");

        // 移除多餘的大括號（視需要）
        cCode = cCode.replaceAll("\\}", "}");

        // 移除 class 結尾的 }
        cCode = cCode.replaceAll("\\}\\s*$", "");

        return "#include <stdio.h>\n\n" + cCode.trim();


    }
}
