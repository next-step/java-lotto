package calculator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringAddCalculator {

    private static final String delimiters = ",|:";
    private static final String negative = "-";
    private static final Pattern customPattern = Pattern.compile("//(.)\n(.*)");

    public int splitAndSum(String data) {
        if (isBlank(data)) {
            return 0;
        }

        validateNegative(data);

        Matcher matcher = findMatcher(data);
        String combinedDelimiters = delimiters;

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
        if (data.contains(negative)) {
            throw new RuntimeException("음수 데이터가 있습니다.");
        }
    }

    private Matcher findMatcher(String data) {
        return customPattern.matcher(data);
    }

    private String findNumber(Matcher matcher) {
        return matcher.group(2);
    }

    private String findDelimiters(Matcher matcher) {
        return String.join("|", delimiters, matcher.group(1));
    }

}
