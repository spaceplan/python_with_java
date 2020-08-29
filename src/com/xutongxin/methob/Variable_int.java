package com.xutongxin.methob;

import java.util.HashMap;
import java.util.Map;

public class Variable_int {
    private static Map<String,Integer> function = new HashMap();

    public static int getFunction(String name) {
        return function.get(name);
    }

    public static void setFunction(String name, int value) {
        function.put(name,value);
    }

}
