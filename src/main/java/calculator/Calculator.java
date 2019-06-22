package calculator;

import java.util.List;

public class Calculator {

    public static final int BLANK_VALUE = 0;

    public static int process(String inputValue) {

        if (isBlank(inputValue)) {
            return BLANK_VALUE;
        }

        Input input = new Input(inputValue);
        Tokens tokens = new Tokens(input.split());
        return sum(tokens.convertToIntegers());
    }

    private static boolean isBlank(String input) {

        return input == null || input.isEmpty();
    }

    private static int sum(List<Integer> numbers) {

        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
