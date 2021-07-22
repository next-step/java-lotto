package string_add_calculator;

import util.StringUtils;

import java.util.Arrays;

public class StringAddCalculator {

    private StringAddCalculator() {}

    public static int calculate(String expressionString) {
        if (StringUtils.isEmpty(expressionString)) {
            return 0;
        }

        String[] numberStrings = expressionString.split("[,|:]");

        return Arrays.stream(numberStrings)
                .mapToInt(StringAddCalculator::parseNaturalNumber)
                .sum();
    }

    private static int parseNaturalNumber(String x) {
        try {
            int number = Integer.parseInt(x);
            if (number < 0) {
                throw new RuntimeException();
            }
            return number;
        } catch (Exception e) {
            throw new RuntimeException("Split token is not natural number : " + x);
        }
    }
}
