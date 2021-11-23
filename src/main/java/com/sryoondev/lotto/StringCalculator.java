package com.sryoondev.lotto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static int splitAndSum(String text) {
        if (isEmptyString(text)) {
            return 0;
        }

        String[] tokens = text.split(",|:");
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            tokens= m.group(2).split(customDelimiter);
        }
        int result = 0;
        for (String token : tokens) {
            int number = Integer.parseInt(token);
            if (number < 0) {
                throw new RuntimeException();
            }
            result += number;
        }
        return result;
    }

    public static boolean isEmptyString(String text) {
        return text == null || text.isEmpty();
    }
}
