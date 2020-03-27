package calculator.domain;

import java.util.List;

public class Calculator {
    public static int calculate(String expression) {
        List<String> numberValues = CalculatorHelper.findNumber(expression);

        return add(Number.listOf(numberValues));
    }

    private static int add(List<Number> numbers) {
        int result = 0;
        for (Number number : numbers) {
            result = number.sum(result);
        }

        return result;
    }
}
