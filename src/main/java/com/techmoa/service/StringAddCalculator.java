package com.techmoa.service;

import java.util.Arrays;

public class StringAddCalculator {
    public static String targetStr = "";
    public static int result = 0;
    public static final String REGEXSPLIT =",|;";

    public static int splitAndSum(String inputStr) {
        targetStr = inputStr;
        if(checkNullStr()) {
            checkOneChar();
            checkComa();
        }
        return result;
    }

    private static void checkComa() {
        String paramSums[] = targetStr.split(REGEXSPLIT);
        result = Arrays.stream(paramSums)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    public static boolean checkNullStr() {
        if(targetStr == null || targetStr.isEmpty()) {
            result = 0;
            return false;
        }
        return true;
    }

    public static void checkOneChar() {
        if(targetStr.length() == 1)
            result =  Integer.parseInt(targetStr);
    }


}
