package com.sryoondev.lotto;

public class StringCalculator {
    public static int splitAndSum(String text) {
        String[] tokens = text.split(",|:");
        int result = 0;
        for (String token : tokens) {
            result += Integer.parseInt(token);
        }
        return result;
    }
}
