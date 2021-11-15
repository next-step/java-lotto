package com.kakao.stringadder.domain.splitter;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

class CustomSplitter implements Splitter {

    private final String delimiter;

    public CustomSplitter(String delimiter) {
        this.delimiter = delimiter;
    }

    @Override
    public List<String> split(String input) {
        return Arrays.asList(input.split(Pattern.quote(delimiter)));
    }
}
