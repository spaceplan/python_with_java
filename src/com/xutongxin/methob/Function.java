package com.xutongxin.methob;

import java.util.HashMap;
import java.util.Map;

public class Function {
    private Map<String,Integer> function = new HashMap();

    public int getFunction(String name) {
        return function.get(name);
    }

    public void setFunction(String name, int locate) {
        function.put(name,locate);
    }

    public static void main(String[] args) {
        Function a = new Function();

        a.setFunction("hello", 12);
        String b= Integer.toString(a.getFunction("hello"));
        System.out.println(b);
    }
}
