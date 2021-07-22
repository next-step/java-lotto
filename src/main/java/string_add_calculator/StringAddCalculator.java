package string_add_calculator;

import util.StringUtils;

import java.util.Arrays;

public class StringAddCalculator {

    public int calculate(String expressionString) {
        if (StringUtils.isEmpty(expressionString)) {
            return 0;
        }

        String[] numberStrings = expressionString.split("[,|:]");

        return Arrays.stream(numberStrings)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
