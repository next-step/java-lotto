package stringcalculator.domain;

import java.util.stream.Collectors;

public class StringAddCalculator {

    public static long execute(final String expression) {
        if (isNullOrEmpty(expression)) {
            return 0;
        }

        StringExpressionConverter.convert(expression)
                .stream()
                .map(Operand::new)
                .collect(Collectors.toList());
        return 0;
    }

    private static boolean isNullOrEmpty(String expression) {
        return expression == null || expression.isEmpty();
    }
}
