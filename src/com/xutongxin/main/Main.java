package com.xutongxin.main;

import com.xutongxin.methob.Function;
import com.xutongxin.methob.Variable_int;
import com.xutongxin.methob.Compare;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;


public class Main {
    public static int line = 1, begin = 0, tab = 0, line_all = 1;
    public static boolean[] ifword;
    private static final String fileroad = "C://GitProject//python_with_java//test.py";
    public static ArrayList<String> file= new ArrayList<String>();

    //private final String fileroad="E://GitProject//python_with_java//test.py";
    public static void main(String[] args) throws IOException {
        //BufferedReader是可以按行读取文件
        FileInputStream inputStream = new FileInputStream(fileroad);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        //String line32 = Files.readAllLines(Paths.get(fileroad)).get(32);
        String str = null;
        file.clear();
        file.add("");
        while ((str = bufferedReader.readLine()) != null) {
            print(String.valueOf(line));
            file.add(str);
            prepare(str);
            line = line + 1;
        }
        line_all=line-1;
        if (begin == 0) {
            System.out.println("没有初始化程序的 if __name__ == '__main__': 语句");
            System.exit(100);
        }
        inputStream.close();
        bufferedReader.close();
        Function.printValue();

        System.out.println(begin);
        print(String.valueOf(line_all));
        // 完成初始化，开始读行
        line = 1;
        tab=1;
        readline(begin+1,line_all);
        Variable_int.printValue();
    }

    public static void prepare(String str) {

        if (str.equals("") || str.charAt(0) == ' ' || str.charAt(0) == '#')
            return;
        switch (str.charAt(0)) {
            case 'd':
                if (str.length() > 3 && str.substring(tab * 4, tab * 4 + 4).equals("def ")) {
                    Function.setFunction(str.substring(4, str.indexOf("(")), line);
                    break;
                } else
                    setValue(str);
                break;
            case 'i':
                if (str.length() > 25 && "if __name__ == '__main__':".equals(str.substring(0, 26)))
                    begin = line;
                else
                    setValue(str);
                break;
            default: {
                //System.out.println(str.charAt(3));

                setValue(str);

                break;


            }

        }
    }

    public static void setValue(String str) {
        try {
            Variable_int.setValue(str.substring(0, str.indexOf("=")), Integer.parseInt((str.substring(str.indexOf("=") + 1)).trim()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("第 " + line + " 行赋值时出现问题，请检查");
            System.exit(101);
        }

    }

    public static void run(String str) {
        if(str.equals(""))
            return;
        while(tab != 1 && str.charAt(tab * 4) != ' ') {
            if(ifword[tab])
                ifword[tab]=false;
            tab=tab-1;
            return;
        }
        switch (str.charAt(tab * 4)) {
            case '#':
                return;
            case 'i': {
                if ("if".equals(str.substring(0, 2))) {
                    tab += 1;
                    ifword[tab] = true;
                    Compare.run(str.substring(tab * 4 + 2, str.indexOf(":")).trim());

                } else
                    setValue(str);
                break;
            }
            case 'e': {
                if ("elif".equals(str.substring(0, 4))) {
                    if (!ifword[tab]) {
                        wrong();
                        return;
                    }
                    tab += 1;
                    ifword[tab] = true;

                } else if ("else".equals(str.substring(0, 4))) {
                    if (!ifword[tab]) {
                        wrong();
                        return;
                    }
                    tab += 1;
                    ifword[tab] = true;
                } else
                    setValue(str);
                break;
            }

            case 'p': {
                if (str.substring(tab*4, tab*4+6).equals("print("))
                    System.out.println(str.substring(tab*4+7, str.indexOf(")")-1));

                else
                    setValue(str);
                break;
            }
            //case 'o':
            //if(str.substring(0,4) == "out.")
            default:
                setValue(str);
        }
    }

    public static void readline(Integer from, Integer to)  {
        tab = 1;
        int line = from;
        String str=null;
        while (to >= line) {
            str = file.get(line);
            run(str);
            line = line + 1;
        }
    }

    public static void wrong() {
        System.out.println(line + " 行语法错误");
    }

    public static void print(String str) {
        System.out.println(str);
    }
    public static boolean isNumeric(String str) {
        String bigStr;
        try {
            bigStr = new BigDecimal(str).toString();
        } catch (Exception e) {
            return false;//异常 说明包含非数字。
        }
        return true;
    }
}
