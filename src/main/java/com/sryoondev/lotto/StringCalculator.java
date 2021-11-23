package com.sryoondev.lotto;

public class StringCalculator {
    public static int splitAndSum(String text) {
        String[] tokens = text.split(",");
        int result = 0;
        for (int i = 0; i < tokens.length; i++) {
            result += Integer.parseInt(tokens[i]);
        }
        return result;
    }
}
