package com.xutongxin.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;




public class main {

    public static void main(String[] args) throws IOException
    {

        //BufferedReader是可以按行读取文件
        FileInputStream inputStream = new FileInputStream("C://Users//xtx//Documents//a.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String str = null;
        while((str = bufferedReader.readLine()) != null)
        {
            System.out.println(str);
        }

        //close
        inputStream.close();
        bufferedReader.close();

    }

}
