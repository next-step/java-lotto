package string_add_calculator;

import string_add_calculator.domain.NaturalNumber;
import string_add_calculator.tokenizer.ExpressionTokenizer;
import util.StringUtils;

import java.util.Arrays;

public class StringAddCalculator {

    private StringAddCalculator() {}

    public static int calculate(String expression) {
        if (StringUtils.isEmpty(expression)) {
            return 0;
        }

        String[] numberTokens = ExpressionTokenizer.split(expression);

        return Arrays.stream(numberTokens)
                .map(NaturalNumber::of)
                .mapToInt(NaturalNumber::toInt)
                .sum();
    }
}
