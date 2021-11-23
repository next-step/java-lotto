package com.sryoondev.lotto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static final String DEFAULT_DELIMITER = ",|:";
    public static final String CUSTOM_DELIMITER_START_KEYWORD = "//";
    public static final String CUSTOM_DELIMITER_END_KEYWORD = "\n";

    public static int splitAndSum(String text) {
        if (isEmptyString(text)) {
            return 0;
        }
        String[] tokens = split(text);
        int result = 0;
        for (String token : tokens) {
            result += validate(token);
        }
        return result;
    }

    public static boolean isEmptyString(String text) {
        return text == null || text.isEmpty();
    }

    public static String[] split(String text) {
        if (text.startsWith(CUSTOM_DELIMITER_START_KEYWORD)) {
            return splitByCustomDelimiter(text);
        }
        return splitByDefaultDelimiter(text);
    }

    public static String[] splitByDefaultDelimiter(String text) {
        return text.split(DEFAULT_DELIMITER);
    }

    public static String[] splitByCustomDelimiter(String text) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_START_KEYWORD + "(.)" +
                CUSTOM_DELIMITER_END_KEYWORD + "(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        throw new RuntimeException("커스텀 구분자가 입력되지 않았습니다.");
    }

    public static int validate(String token) {
        int number = Integer.parseInt(token);
        if (number < 0) {
            throw new RuntimeException();
        }
        return number;
    }
}
