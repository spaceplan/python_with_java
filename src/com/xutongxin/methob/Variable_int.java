package com.xutongxin.methob;

import java.util.HashMap;
import java.util.Map;

public class Variable_int {
    private static Map<String,Integer> Variable_int = new HashMap();

    public static int getValue(String name) {
        return Variable_int.get(name);
    }

    public static void setValue(String name, int value) {
        Variable_int.put(name.trim(),value);
    }
    public static void printValue(){System.out.println(Variable_int);}
    public static boolean check(String str){return Variable_int.containsKey(str);}
}
