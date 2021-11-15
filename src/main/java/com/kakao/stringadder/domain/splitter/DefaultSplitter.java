package com.kakao.stringadder.domain.splitter;

import java.util.Arrays;
import java.util.List;

class DefaultSplitter implements Splitter {

    private static final String DEFAULT_DELIMITER = "[,:]";

    @Override
    public List<String> split(String input) {
        return Arrays.asList(input.split(DEFAULT_DELIMITER));
    }
}
