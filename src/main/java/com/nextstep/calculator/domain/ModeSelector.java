package com.nextstep.calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ModeSelector {
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");

    private final Matcher matcher;
    private final String value;

    public ModeSelector(final String value) {
        this.matcher = CUSTOM_PATTERN.matcher(value);
        this.value = value;
    }

    public Mode select() {
        if (isCustom()) {
            return new CustomMode(matcher.group(2), matcher.group(1));
        }
        return new NormalMode(value);
    }

    boolean isCustom() {
        return matcher.find();
    }
}
