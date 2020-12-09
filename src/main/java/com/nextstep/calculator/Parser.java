package com.nextstep.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");

    private Parser(){}

    public static Splitter parse(String source) {
        Matcher matcher = PATTERN.matcher(source);
        if (matcher.find()) {
            String delimiter = matcher.group(1);
            String numbers = matcher.group(2);
            return new Splitter(numbers, delimiter);
        }
        return new Splitter(source);
    }
}
