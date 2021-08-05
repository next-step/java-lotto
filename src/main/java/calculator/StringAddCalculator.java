package calculator;

import java.util.Arrays;
import java.util.List;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";

    public int calculate(String input) {
        return parse(input).stream()
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private List<String> parse(String input) {
        return Arrays.asList(input.split(DEFAULT_DELIMITER_REGEX));
    }
}
