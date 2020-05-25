package me.daeho.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddParser {
    private static final String DEFAULT_REGEX = ",|:";
    private static final String CUSTOM_REGEX =  "//(.)\n(.*)";

    public static String[] parsing(String text) {
        Matcher m = Pattern.compile(CUSTOM_REGEX).matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return parsingDefault(text);
    }

    private static String[] parsingDefault(String data) {
        return data.split(DEFAULT_REGEX);
    }
}
