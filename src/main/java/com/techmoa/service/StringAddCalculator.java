package com.techmoa.service;

public class StringAddCalculator {
    public static int result = 0;
    public static int splitAndSum(String inputStr) {
        if(checkNullStr(inputStr)) {
            checkOneChar(inputStr);
        }

        return result;
    }
    public static boolean checkNullStr(String inputStr) {
        if(inputStr == null || inputStr.isEmpty()) {
            result = 0;
            return false;
        }
        return true;
    }
    public static void checkOneChar(String inputStr) {
        if(inputStr.length() == 1)
            result =  Integer.parseInt(inputStr);
    }
}
