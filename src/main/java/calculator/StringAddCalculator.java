package calculator;

import java.util.Arrays;
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
    private static final String COMMA_OR_COLON = ",|:";
    private static final int DEFAULT_SUM = 0;

    public StringAddCalculator() {
    }

    public int splitAndSum(String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            return DEFAULT_SUM;
        }
        return sum(splitByPattern(CUSTOM_DELIMITER_PATTERN, input));
    }

    private int sum(List<String> strings) {
        return createPositiveNumbersBy(strings).stream()
            .reduce(new PositiveNumber(DEFAULT_SUM), (x, y) -> x.add(y))
            .getNumber();
    }

    private List<PositiveNumber> createPositiveNumbersBy(List<String> strings) {
        return strings
            .stream()
            .map(PositiveNumber::new)
            .collect(Collectors.toList());
    }

    private List<String> splitByPattern(Pattern pattern, String input) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return Arrays.asList(matcher.group(2).split(customDelimiter));
        }
        return splitByCommaOrColon(input);
    }

    private List<String> splitByCommaOrColon(String input) {
        return Arrays.asList(input.split(COMMA_OR_COLON));
    }
}
