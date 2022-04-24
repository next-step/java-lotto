package stringcalculator;


import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class StringCalculator {

    public static final String DELIMITER = " ";

    private StringCalculator() {
        throw new AssertionError();
    }

    public static int calculate(String input) {
        validate(input);
        List<String> inputs = split(input);
        return calculate(inputs);
    }

    private static void validate(String input) {
        Objects.requireNonNull(input, "입력값은 null 일 수 없습니다.");
        if (input.isBlank()) {
            throw new IllegalArgumentException("입력값은 빈 문자열일 수 없습니다.");
        }
    }

    private static List<String> split(String input) {
        return Arrays.asList(input.split(DELIMITER));
    }

    private static int calculate(List<String> inputs) {
        int baseNumber = Integer.parseInt(inputs.get(0));
        for (int i = 1; i < inputs.size() - 1; i++) {
            String operator = inputs.get(i);
            int targetNumber = Integer.parseInt(inputs.get(++i));
            baseNumber = calculate(baseNumber, operator, targetNumber);
        }
        return baseNumber;
    }

    private static int calculate(int baseNumber, String operator, int targetNumber) {
        if ("+".equals(operator)) {
            return baseNumber + targetNumber;
        }
        if ("-".equals(operator)) {
            return baseNumber - targetNumber;
        }
        if ("/".equals(operator)) {
            return baseNumber / targetNumber;
        }
        if ("*".equals(operator)) {
            return baseNumber * targetNumber;
        }
        throw new IllegalArgumentException("올바르지 않은 연산자입니다. : " + operator);
    }
}
