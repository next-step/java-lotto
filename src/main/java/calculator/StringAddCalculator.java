package calculator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringAddCalculator {

    private static final String DELIMITERS = ",|:";
    private static final String NEGATIVE = "-";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int NUMBER_PART = 2;
    private static final int DELIMITER_PART = 1;

    public int splitAndSum(String data) {
        if (isBlank(data)) {
            return 0;
        }

        validateNegative(data);

        Matcher matcher = findMatcher(data);
        String combinedDelimiters = DELIMITERS;

        if (matcher.find()) {
            data = findNumber(matcher);
            combinedDelimiters = findDelimiters(matcher);
        }

        String[] tokens = data.split(combinedDelimiters);

        return sum(tokens);
    }

    private int sum(String[] tokens) {
        return Stream.of(tokens)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private boolean isBlank(String data) {
        if (Objects.isNull(data) || data.isEmpty()) {
            return true;
        }
        return false;
    }

    private void validateNegative(String data) {
        if (data.contains(NEGATIVE)) {
            throw new RuntimeException("음수 데이터가 있습니다.");
        }
    }

    private Matcher findMatcher(String data) {
        return CUSTOM_PATTERN.matcher(data);
    }

    private String findNumber(Matcher matcher) {
        return matcher.group(NUMBER_PART);
    }

    private String findDelimiters(Matcher matcher) {
        return String.join("|", DELIMITERS, matcher.group(DELIMITER_PART));
    }

}
