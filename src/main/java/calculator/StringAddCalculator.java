package calculator;

import java.util.Arrays;

public class StringAddCalculator {

    public int calculate(String input) {
        if (input.isEmpty() || input == null) {
            return 0;
        }

        if (input.length() == 1) {
            return Integer.parseInt(input);
        }

        String[] numbers = getNumbers(input);

        int result = sum(numbers);

        return result;
    }

    private Integer sum(String[] numbers) {
        Integer result;
        result = Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
        return result;
    }

    private String[] getNumbers(String input) {
        return input.split(",");
    }
}
