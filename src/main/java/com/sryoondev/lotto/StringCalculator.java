package com.sryoondev.lotto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static int splitAndSum(String text) {
        if (isEmptyString(text)) {
            return 0;
        }
        String[] tokens = split(text);
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

    public static String[] split(String text) {
        if (text.startsWith("//")) {
            return splitByCustomDelimiter(text);
        }
        return splitByDefaultDelimiter(text);
    }

    public static String[] splitByDefaultDelimiter(String text) {
        return text.split(",|:");
    }

    public static String[] splitByCustomDelimiter(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        throw new RuntimeException("커스텀 구분자가 입력되지 않았습니다.");
    }

}
