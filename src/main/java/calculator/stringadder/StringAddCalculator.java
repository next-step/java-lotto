package calculator.stringadder;

import calculator.stringadder.domain.NaturalNumber;
import calculator.stringadder.tokenizer.ExpressionTokenizer;
import util.StringUtils;

import java.util.Arrays;

import static calculator.stringadder.domain.NaturalNumber.ZERO_VALUE;

public class StringAddCalculator {

    private StringAddCalculator() {}

    public static int calculate(String expression) {
        if (StringUtils.isEmpty(expression)) {
            return ZERO_VALUE;
        }

        String[] numberTokens = ExpressionTokenizer.split(expression);

        return Arrays.stream(numberTokens)
                .map(NaturalNumber::from)
                .reduce(NaturalNumber.ZERO, NaturalNumber::add)
                .toInt();
    }
}
