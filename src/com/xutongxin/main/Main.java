package com.xutongxin.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;




public class Main {

    public static void main(String[] args) throws IOException
    {
        //String fileroad="C://Users//xtx//Documents//a.txt";
        String fileroad="E://a.txt";
        //BufferedReader是可以按行读取文件
        FileInputStream inputStream = new FileInputStream(fileroad);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String str = null;
        while((str = bufferedReader.readLine()) != null)
        {
            System.out.println(str.charAt(1));
        }

        //close
        inputStream.close();
        bufferedReader.close();

    }
    public static void run(String str)
    {
        switch (str.charAt(0)) {
            case ' ':
                System.out.println("你的编程规范呢");
            case 'd':
                
        }
        }
    }
}
