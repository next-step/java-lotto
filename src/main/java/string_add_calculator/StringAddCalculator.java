package string_add_calculator;

import string_add_calculator.domain.NaturalNumber;
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
                .map(NaturalNumber::of)
                .mapToInt(NaturalNumber::toInt)
                .sum();
    }
}
