package com.xutongxin.methob;

import com.xutongxin.methob.Variable_int;

import java.math.BigDecimal;

public class Expression {
    public static int run(String str)
    {
        str=str.trim();
        if(str.contains("*"))
            return run(str.substring(0,str.indexOf("*")))*run(str.substring(str.indexOf("*")+1));
        if(str.contains("/"))
            return run(str.substring(0,str.indexOf("/")))/run(str.substring(str.indexOf("/")+1));
        if(str.contains("%"))
            return run(str.substring(0,str.indexOf("%")))%run(str.substring(str.indexOf("%")+1));
        if(str.contains("+"))
            return run(str.substring(0,str.indexOf("+")))+run(str.substring(str.indexOf("+")+1));
        if(str.contains("-"))
            return run(str.substring(0,str.indexOf("-")))-run(str.substring(str.indexOf("-")+1));
        if(isNumeric(str))
            return Integer.valueOf(str);
        else if (Variable_int.check(str))
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
    public static boolean isNumeric(String str) {
        String bigStr;
        try {
            bigStr = new BigDecimal(str).toString();
        } catch (Exception e) {
            return false;//异常 说明包含非数字。
        }
        return true;
    }
    public static void wrong(String str) {
        System.out.println(str + " 表达语句语法错误。请注意，当前版本不支持带括号的复杂运算");
    }
}
