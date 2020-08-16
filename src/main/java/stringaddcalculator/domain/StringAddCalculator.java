package stringaddcalculator.domain;

import java.util.Arrays;

public class StringAddCalculator {
    public static int commaSum(String expression) {
        String[] numbers = expression.split(",");
        return Arrays.stream(numbers)
                .map(number -> Integer.parseInt(number))
                .reduce(0, Integer::sum);
    }
}
