package com.xutongxin.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import com.xutongxin.methob.Function;


public class Main {
    public static int line = 1, begin = 0, ifword = 0, tab = 0;

    public static void main(String[] args) throws IOException {
        //String fileroad="C://Users//xtx//Documents//a.txt";
        String fileroad = "E://a.txt";
        //BufferedReader是可以按行读取文件
        FileInputStream inputStream = new FileInputStream(fileroad);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String str = null;
        while ((str = bufferedReader.readLine()) != null) {
            System.out.println(str.charAt(1));
            line = line + 1;
        }

        //close
        inputStream.close();
        bufferedReader.close();

    }

    public static void run(String str) {
        if (tab!=0&& str.charAt(0)!='\t') {
            tab = 0;
            return;
        }
        switch (str.charAt(tab)) {
            case ' ': {
                System.out.println("你的编程规范呢");
                return;
            }
            case 'd':
                if (str.substring(0, 4) == "def ")
                    Function.setFunction(str.substring(4, str.indexOf("(")), line);
            case 'i':
                if ("if __name__ == \"__main__\":" == str.substring(0, 26)) {
                    begin = line;
                    tab += 1;
                } else if ("if" == str.substring(0, 2)) {
                    ifword += 1;
                    tab += 1;
                }

                else if ("elif" == str.substring(0, 4) && ifword != 0)

                else if ("else" == str.substring(0, 4) && ifword != 0)
            case 'p':
                if(str.substring(0, 6) == "print(")
                    System.out.println(str.substring(7,str.indexOf(")") ));
        //case 'o':
        //if(str.substring(0,4) == "out.")

    }
}
}
