package com.mybaitis.io;

import java.io.InputStream;

/**
 * 使用类加载器读取配置文件的类
 */
public class Resources {
    /**
     * 根据传入的参数，获取一个字节输入流
     * @param filePath
     * @return
     */
    public static InputStream getResourceAsStream(String filePath){
        //1.Resources.class 拿到当前类的字节码
        //2.class.getClassLoader() 获取字节码的类加载器
        //3.getResourceAsStream(filePath) 根据类加载器读取配置
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}
