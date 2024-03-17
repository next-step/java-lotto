package study;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    private final String INVALID_EXPRESSION = "올바르지 않은 수식입니다.";

    public int calculate(String input) {
        assertNotEmptyOrNull(input);
        List<String> expression = List.of(input.split(" "));

        try {
            return calculate(expression);
        } catch (IndexOutOfBoundsException exception) {
            throw new IllegalArgumentException(INVALID_EXPRESSION);
        }
    }

    private int calculate(List<String> expression) {
        int result = toInteger(expression.get(0));

        for (int i = 1; i < expression.size(); i+=2) {
            FourOperation fourOperation = FourOperation.findBySign(expression.get(i));
            int number = toInteger(expression.get(i + 1));

            result = fourOperation.apply(result, number);
        }

        return result;
    }

    private int toInteger(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(INVALID_EXPRESSION);
        }
    }

    private void assertNotEmptyOrNull(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(INVALID_EXPRESSION);
        }
    }
}
