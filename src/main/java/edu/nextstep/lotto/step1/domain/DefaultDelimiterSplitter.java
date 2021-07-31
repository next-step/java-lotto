package edu.nextstep.lotto.step1.domain;

import edu.nextstep.lotto.step1.vo.Tokens;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DefaultDelimiterSplitter implements DelimiterSplitter {

    private static final String DEFAULT_DELIMITER_PATTERN = "[,:]";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";

    @Override
    public Tokens split(String text) {

        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(text);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return new Tokens(matcher.group(2).split(customDelimiter));
        }

        return new Tokens(text.split(DEFAULT_DELIMITER_PATTERN));
    }
}
