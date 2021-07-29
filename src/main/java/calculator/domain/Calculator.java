package calculator.domain;

import calculator.domain.tonkenizer.TokenizeOperator;

import java.util.Arrays;

import static calculator.utils.StringUtil.isNullOrEmpty;

public class Calculator {
    private static final int MIN = 0;

    public static int calculate(String input) {
        if (isNullOrEmpty(input)) {
            return MIN;
        }

        return Arrays.stream(TokenizeOperator.split(input))
                .map(NaturalNumber::of)
                .reduce(NaturalNumber.of(0), NaturalNumber::add)
                .toInt();
    }
}
