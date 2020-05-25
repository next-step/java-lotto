package me.daeho.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddParser {
    private static final String DEFAULT_REGEX = ",|:";
    private static final String CUSTOM_REGEX =  "//(.)\n(.*)";

    private final String text;

    private StringAddParser(String text) {
        this.text = text;
    }

    public static StringAddParser create(String text) {
        return new StringAddParser(text);
    }

    public String[] parsing() {
        Matcher m = Pattern.compile(CUSTOM_REGEX).matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return parsingDefault(text);
    }

    private String[] parsingDefault(String data) {
        return data.split(DEFAULT_REGEX);
    }
}
