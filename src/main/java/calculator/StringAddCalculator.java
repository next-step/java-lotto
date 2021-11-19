package calculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author han
 */
public class StringAddCalculator {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int DEFAULT_SUM = 0;

    public StringAddCalculator() {
    }


    public int splitAndSum(String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            return DEFAULT_SUM;
        }

        List<String> strings = splitByPattern(CUSTOM_DELIMITER_PATTERN, input);

        if (Objects.isNull(strings) || strings.isEmpty()) {
            return sum(splitByCommaOrColon(input));
        }

        return sum(strings);
    }

    private List<PositiveNumber> createPositiveNumbersBy(List<String> strings) {
        return strings
            .stream()
            .map(PositiveNumber::of)
            .collect(Collectors.toList());
    }

    private int sum(List<String> strings) {
        return createPositiveNumbersBy(strings)
            .stream()
            .mapToInt(PositiveNumber::getNumber)
            .sum();
    }

    private List<String> splitByPattern(Pattern pattern, String input) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return Arrays.asList(matcher.group(2).split(customDelimiter));
        }

        return Collections.emptyList();
    }

    private List<String> splitByCommaOrColon(String input) {
        return Arrays.asList(input.split(",|:"));
    }
}
