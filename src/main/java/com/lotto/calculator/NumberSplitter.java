package com.lotto.calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberSplitter {
    private static final String DEFAULT_SEPERATOR_REGEX = ",|:";
    private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile("^//(.)\n.*");
    private static final Pattern INPUT_NUMBERS_PATTERN = Pattern.compile("\n(.*)$");
    private static final String EMPTY = "";

    public static int[] split(String input) {
        String SeparatorRegex = makeSeparatorRegex(input);
        String numberLine = extractNumberLine(input);

        return Arrays.stream(numberLine.split(SeparatorRegex))
                .mapToInt(Integer::valueOf).toArray();
    }

    private static String extractNumberLine(String input) {
        Matcher matcher = INPUT_NUMBERS_PATTERN.matcher(input);

        if (!matcher.find()) {
            return input;
        }

        return matcher.group(1);
    }

    private static String makeSeparatorRegex(String input) {
        String customRegex = extractCustomSeparator(input);

        if(EMPTY.equals(customRegex)) {
            return DEFAULT_SEPERATOR_REGEX;
        }

        return customRegex + "|" + DEFAULT_SEPERATOR_REGEX;
    }

    private static String extractCustomSeparator(String input) {
        Matcher matcher = CUSTOM_SEPARATOR_PATTERN.matcher(input);

        if (matcher.find()) {
            return matcher.group(1);
        }

        return EMPTY;
    }
}
