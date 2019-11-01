package util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toList;

public class StringParser {
    private static final String CUSTOM_PATTERN = "//(.)\n(.*)";
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String NUMBER_FORMAT = "\\d+";
    private static final String EMPTY = "";

    public static List<Integer> parse(final String input) {
        if (validateInput(input)) {
            return Collections.singletonList(0);
        }
        List<String> parsed = parseWithDelimiter(input);
        return convert(parsed);
    }

    private static boolean validateInput(String input) {
        return (input == null) || (input.trim().equals(EMPTY));
    }

    private static List<String> parseWithDelimiter(final String input) {
        Matcher matcher = Pattern.compile(CUSTOM_PATTERN)
                .matcher(input);

        if (hasCustomDelimiter(matcher)) {
            return parseWithCustomDelimiter(matcher);
        }

        return Arrays.asList(input.split(DEFAULT_DELIMITER));
    }

    private static List<String> parseWithCustomDelimiter(Matcher matcher) {
        String delimiters = combineDelimiter(matcher.group(1));
        String matchInput = matcher.group(2);
        return Arrays.asList(matchInput.split(delimiters));
    }

    private static String combineDelimiter(String customDelimiter) {
        return String.join("|", customDelimiter, DEFAULT_DELIMITER);
    }

    private static List<Integer> convert(List<String> parsed) {
        return parsed.stream()
                .filter(StringParser::isNumber)
                .map(Integer::parseInt)
                .collect(toList());
    }

    private static boolean isNumber(String maybeNumber) {
        if (!maybeNumber.matches(NUMBER_FORMAT)) {
            throw new RuntimeException(maybeNumber + "는 숫자가 아닙니다.");
        }
        return true;
    }

    private static boolean hasCustomDelimiter(Matcher matcher) {
        return matcher.find();
    }
}
