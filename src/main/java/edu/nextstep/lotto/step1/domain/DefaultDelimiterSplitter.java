package edu.nextstep.lotto.step1.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DefaultDelimiterSplitter implements DelimiterSplitter {

    private static final String DEFAULT_DELIMITER_PATTERN = "[,:]";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";

    @Override
    public List<String> split(String text) {

        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(text);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return Arrays.asList(matcher.group(2).split(customDelimiter));
        }

        return Arrays.asList(text.split(DEFAULT_DELIMITER_PATTERN));
    }
}
