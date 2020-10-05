package com.example.tutorial2;

public class ConvertName {
    public static String changeName(String name){
        String result = "Hello " + name + "!";
        if (name.equals("")){
            result = "Hello Strangers!";
        }
        return result;
    }
}
