package com.calculator;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSeparator implements SeparatorStrategy {

    public static final String PREFIX = "//";
    public static final String POSTFIX = "\n";

    private String processedText;
    private String customDelimiter;

    public CustomSeparator(String inputText) {
        Matcher matcher = Pattern.compile(PREFIX + "(.)" + POSTFIX + "(.*)").matcher(inputText);
        if (matcher.find()) {
            this.customDelimiter = matcher.group(1);
            this.processedText = matcher.group(2);
        }
    }

    @Override
    public List<String> getSeparatedInputs() {
        String[] spiltProcessedText = StringUtils.split(this.processedText, this.customDelimiter);
        return Arrays.asList(spiltProcessedText);
    }
}
