package com.techmoa.service;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static String targetStr = "";
    public static int result = 0;
    public static final String REGEXSPLIT =",|:";

    public static int splitAndSum(String inputStr) {
        targetStr = inputStr;
        if(checkNullStr()) {
            checkOneChar();
            checkCustomSeparator();
        }
        return result;
    }

    private static void checkCustomSeparator() {
        if(targetStr.contains("//")) {
            convertCustomPatten();
            return;
        }
        add(targetStr.split(REGEXSPLIT));
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

    public static void add(String paramSums[]){
        result = Arrays.stream(paramSums)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    public static void convertCustomPatten() {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(targetStr);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            add(tokens);
        }
    }


}
