
package dev.dahye.calculator;

public class StringAddCalculator {
    private static final String DEFAULT_SEPARATOR = "[,:]";

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] numbers = split(input);

        return sum(numbers);
    }

    private static String[] split(String input) {
        return input.split(DEFAULT_SEPARATOR);
    }

    private static int sum(String[] numbers) {
        int result = 0;
        for (String number : numbers) {
            result += Integer.parseInt(number);
        }

        return result;
    }

}
