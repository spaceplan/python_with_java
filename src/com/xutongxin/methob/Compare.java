package com.xutongxin.methob;

import com.xutongxin.methob.Expression;
public class Compare {
    public static boolean run(String str)
    {
        str=str.trim();
        int i=0;
        //boolean and=false,or=false;
        if(str.contains("and"))
            return run(str.substring(0,str.indexOf("and")))&&run(str.substring(str.indexOf("and")+3));
        if(str.contains("or"))
            return run(str.substring(0,str.indexOf("or")))||run(str.substring(str.indexOf("or")+2));
        //处理and和or

        if(str.contains("=")) {
            if (str.contains("=="))
                return Expression.run(str.substring(0, str.indexOf("=="))) == Expression.run(str.substring(str.indexOf("==") + 2));
            if (str.contains(">="))
                return Expression.run(str.substring(0, str.indexOf("=="))) >= Expression.run(str.substring(str.indexOf("==") + 2));
            if (str.contains("<="))
                return Expression.run(str.substring(0, str.indexOf("=="))) >= Expression.run(str.substring(str.indexOf("==") + 2));
            if (str.contains("!="))
                return Expression.run(str.substring(0, str.indexOf("!="))) >= Expression.run(str.substring(str.indexOf("==") + 2));

        }
        return true;
    }
}
