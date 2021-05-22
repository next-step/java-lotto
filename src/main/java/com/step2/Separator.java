package com.step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.step2.Matcher.*;

public final class Separator {
    private static final String BASIC_SEPARATOR = ",|:";
    private static final String CUSTOM_SEPARATOR_PATTERN = "//(.)\n(.*)";

    private final Pattern pattern;
    private Matcher matcher;
    private String targetText;

    public Separator(String targetText) {
        if(isNull(targetText)) {
            throw new IllegalArgumentException("입력값이 null 입니다.");
        }
        this.pattern = Pattern.compile(CUSTOM_SEPARATOR_PATTERN);
        this.matcher = pattern.matcher(targetText);
        if(isEmptyText(targetText)) {
            throw new IllegalArgumentException("입력값이 빈 문자열 입니다.");
        }
        this.targetText = targetText;
    }

    private boolean isNull(String targetText) {
        return targetText == null;
    }

    private boolean isEmptyText(String targetText) {
        if (isCustomSeparator()) {
            return matcher.group(2).isEmpty();
        }

        return targetText.isEmpty();
    }

    private boolean isCustomSeparator() {
        return matcher.matches();
    }

    public String[] separate() {
        if (isCustomSeparator()) {
            String customDelimiter = matcher.group(DELIMITER.value());
            return matcher.group(TOKENS.value()).split(customDelimiter);
        }

        return targetText.split(BASIC_SEPARATOR);
    }
}
