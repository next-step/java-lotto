package com.calculator.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSeparator implements SeparatorStrategy {

    public static final String PREFIX = "//";
    public static final String POSTFIX = "\n";
    private static final Pattern pattern = Pattern.compile(PREFIX + "(.)" + POSTFIX + "(.*)");

    private String processedText;
    private String customDelimiter;

    @Override
    public List<String> getSeparatedInputs(String inputText) {

        Matcher matcher = pattern.matcher(inputText);
        if (matcher.find()) {
            this.customDelimiter = matcher.group(1);
            this.processedText = matcher.group(2);
        }

        String[] spiltProcessedText = StringUtils.split(this.processedText, this.customDelimiter);
        return Arrays.asList(spiltProcessedText);
    }
}
