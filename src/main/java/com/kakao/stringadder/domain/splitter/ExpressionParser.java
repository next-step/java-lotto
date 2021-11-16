package com.kakao.stringadder.domain.splitter;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionParser {
    private static final String CUSTOM_PARSE_PATTERN = "//(.)\n(.*)";
    private static final Pattern regexPattern = Pattern.compile(CUSTOM_PARSE_PATTERN);
    private static final DefaultSplitter defaultSplitter = new DefaultSplitter();

    private ExpressionParser() {
    }

    public static List<String> parse(String calculationInput) {
        Matcher matcher = regexPattern.matcher(calculationInput);
        ParserResult result = findPattern(matcher);
        if (result != null){
            return new CustomSplitter(result.delimiter).split(result.input);
        }
        return defaultSplitter.split(calculationInput);
    }

    private static ParserResult findPattern(Matcher matcher) {
        if (matcher.find()) {
            String delimiter = matcher.group(1);
            String input = matcher.group(2);
            return new ParserResult(delimiter, input);
        }
        return null;
    }

    private static class ParserResult {
        private final String delimiter;
        private final String input;

        private ParserResult(String delimiter, String input) {
            this.delimiter = delimiter;
            this.input = input;
        }
    }
}
