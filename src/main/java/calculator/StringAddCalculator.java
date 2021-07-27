package calculator;

import java.util.Arrays;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        int[] operands = AddCalculatorParser.split(input);
        validation(operands);

        return Arrays.stream(operands)
            .sum();
    }

    private static void validation(int[] operands) {
        if (Arrays.stream(operands).anyMatch(i -> i < 0)) {
            throw new RuntimeException();
        }
    }
}
