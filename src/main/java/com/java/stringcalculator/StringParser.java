package com.java.stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {
    private static final String CUSTOM_EXPRESSION = "//(.)\n(.*)";

    public static String[] separatorParser(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_EXPRESSION).matcher(input);
        if (isCustomSeparator(matcher)) {
            return customSeparator(matcher);
        }
        return defaultSeparator(input);
    }

    private static String[] defaultSeparator(String input) {
        return input.split(",|:");
    }

    private static String[] customSeparator(Matcher matcher) {
        String customDelimiter = matcher.group(1);
        return matcher.group(2).split(customDelimiter);
    }

    private static boolean isCustomSeparator(Matcher matcher) {
        return matcher.find();
    }

}
