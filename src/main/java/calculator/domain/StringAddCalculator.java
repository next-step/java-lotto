package calculator.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringAddCalculator {
    private static String EXPRESSION_DEFAULT_SEPARATOR = ",|:";

    public static int splitAndSum(String expression) {
        if (expression == null || expression.isEmpty()) {
            return 0;
        }

        String[] split = expression.split(EXPRESSION_DEFAULT_SEPARATOR);

        CalculatorNumbers calculatorNumbers = new CalculatorNumbers(Arrays.stream(split)
                .map(CalculatorNumber::new)
                .collect(Collectors.toList()));

        return calculatorNumbers.sum();
    }
}
