package com.example.freefreelanse.utils;

public class StringUtils {
    public static String deleteLeters(String s, int a, int b){

        char[] cNew = new char[s.length()-(a+b)];
        String sNew = "";
        for (int i = 0; i < cNew.length; i++) {
            cNew[i] = s.charAt(i+a);
        }
        for (int i = 0; i < cNew.length; i++) {
            sNew =sNew + cNew[i];
        }
        return sNew;
    }
}
