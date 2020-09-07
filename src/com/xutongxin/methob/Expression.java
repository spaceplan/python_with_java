package com.xutongxin.methob;

import com.xutongxin.methob.Variable_int;
public class Expression {
    public static int run(String str)
    {
        str=str.trim();
        if (Variable_int.check("str"))
            return Variable_int.getValue(str);
        else {
            wrong(str);
            System.exit(-2);
        }

        /*
        if (str.charAt(0)=='m')
            return 1;
            //有待处理
        */
        return 1;
    }
    public static void wrong(String str) {
        System.out.println(str + " 表达语句语法错误");
    }
}
