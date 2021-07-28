package calculator;

import calculator.domain.NaturalNumber;
import calculator.domain.tonkenizer.TokenizeOperator;

import java.util.Arrays;

import static calculator.utils.StringUtil.isNullOrEmpty;

public class Calculator {
    private static final int ZERO = 0;

    public static int calculate(String input) {
        if (isNullOrEmpty(input)) {
            return ZERO;
        }

        return Arrays.stream(TokenizeOperator.split(input))
                .map(NaturalNumber::of)
                .reduce(NaturalNumber.of(0), NaturalNumber::add)
                .toInt();
    }
}
