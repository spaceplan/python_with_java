package com.xutongxin.methob;

import java.util.HashMap;
import java.util.Map;

public class Variable_str {
    private static Map<String,String> function = new HashMap();

    public static String getFunction(String name) {
        return function.get(name);
    }

    public static void setFunction(String name, String value) {
        function.put(name,value);
    }
}
