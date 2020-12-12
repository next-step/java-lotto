package study;

import java.util.List;

public class StringAddCalculator {
    private final static int DEFAULT_VALUE = 0;

    public static int splitAndSum(String string) {
        CalculatorInput calculatorInput = new CalculatorInput(string);
        if (calculatorInput.isUnusable()) {
            return DEFAULT_VALUE;
        }
        return sum(calculatorInput.ints());
    }

    private static int sum(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(StringAddCalculator::toNotNegativeNumber).sum();
    }

    private static int toNotNegativeNumber(int number) {
        if (isNegative(number)) {
            throw new RuntimeException();
        }
        return number;
    }

    private static boolean isNegative(int number) {
        return number < DEFAULT_VALUE;
    }
}
