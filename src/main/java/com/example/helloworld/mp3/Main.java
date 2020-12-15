package com.example.helloworld.mp3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

public class Main {



    public static void folderMethod2(String path) {
        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (null != files) {
                for (File temp : files) {
                    if (temp.isDirectory()) {
                        System.out.println("文件夹:" + temp.getAbsolutePath());
                        folderMethod2(temp.getAbsolutePath());
                    } else {
                        System.out.println("文件:" + temp.getName());
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
    }


    private static void renameFile(File file){
        String parent=file.getParent();
        String name=file.getName();


    }

    public static void main(String[] args){
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");
        HelloWorld helloWorld=(HelloWorld) context.getBean("helloWorld");
        helloWorld.sayHello();
        String test="F:\\music\\CloudMusic";
        folderMethod2(test);

        String testPath="F:\\Msse\\ji";
        FileHidden hidden=new FileHidden(testPath);
        try {
            hidden.transform();
//            hidden.restore();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
