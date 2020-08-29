package com.xutongxin.methob;

import java.util.HashMap;
import java.util.Map;

public class Function {
    private static Map<String,Integer> function = new HashMap();

    public static int getFunction(String name) {
        return function.get(name);
    }

    public static void setFunction(String name, int locate) {
        function.put(name,locate);
    }

    public static void main(String[] args) {
        //Function a = new Function();

        setFunction("hello", 12);
        String b= Integer.toString(getFunction("hello"));
        System.out.println(b);
    }
}
