package me.gv7.woodpecker.utils;

import java.io.InputStream;

public class CommonUtil {
    public static String getPayloadContent(String fileName) {
        String content = null;
        try {
            InputStream fileForInput =CommonUtil.class.getClassLoader().getResourceAsStream(fileName);
            byte[] bytes = new byte[fileForInput.available()];
            fileForInput.read(bytes);
            content = new String(bytes,"UTF-8"); // 具体的编码方法
            fileForInput.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }
}
