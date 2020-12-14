package com.ssabae.nextstep.stringcalculator.parser;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author : leesangbae
 * @project : java-lotto
 * @since : 2020-12-14
 */
public class Splitter {

    private static final String SEPARATOR_PATTERN = "//(.*)\n(.*)";
    private static final String BASE_SEPARATOR = "[,:]";
    private static final String EMPTY_VALUE = "0";

    private final Pattern pattern;

    public Splitter() {
        pattern = Pattern.compile(SEPARATOR_PATTERN);
    }

    public List<Integer> split(String text) {
        String value = text;
        if (isBlank(value)) {
            value = EMPTY_VALUE;
        }
        String[] array = splitToArray(value);
        List<Integer> list = Arrays.stream(array)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return Collections.unmodifiableList(list);
    }

    private String[] splitToArray(String text) {
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            String customSeparator = matcher.group(1);
            return matcher.group(2).split(customSeparator);
        }
        return text.split(BASE_SEPARATOR);

    }

    protected boolean isBlank(String str) {
        return str == null || str.trim().length() == 0;
    }

}
