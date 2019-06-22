package com.jaeyeonling.calculate;

import com.jaeyeonling.calculate.utils.StringUtils;

class StringSplitSeparator implements Separator<String> {

    private static final String[] EMPTY = { };

    private final String regex;

    StringSplitSeparator(final String regex) {
        if (StringUtils.isNullOrBlank(regex)) {
            throw new IllegalArgumentException();
        }

        this.regex = regex;
    }

    @Override
    public String[] separate(final String source) {
        if (StringUtils.isNullOrBlank(source)) {
            return EMPTY;
        }

        return source.split(regex);
    }
}
