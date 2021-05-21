package com.step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Separator {
    private static final String BASIC_SEPARATOR = ",|:";
    private static final String CUSTOM_SEPARATOR_PATTERN = "//(.)\n(.*)";
    private final Pattern pattern;
    private final String targetText;
    private Matcher matcher;

    public Separator(String targetText) {
        this.targetText = targetText;
        if(isNull()) {
            throw new IllegalArgumentException("target text is null");
        }
        this.pattern = Pattern.compile(CUSTOM_SEPARATOR_PATTERN);
        this.matcher = pattern.matcher(this.targetText);
        if(isEmptyText()) {
            throw new IllegalArgumentException("target text is empty");
        }
    }

    private boolean isNull() {
        return this.targetText == null;
    }

    private boolean isEmptyText() {
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
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }

        return targetText.split(BASIC_SEPARATOR);
    }
}
