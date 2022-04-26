package stringcalculator;


import java.util.List;
import java.util.Objects;

public class StringCalculator {
    public static final int BASE_NUMBER_INDEX = 0;

    private StringCalculator() {
        throw new AssertionError();
    }

    public static int calculate(String input) {
        validate(input);
        List<String> inputs = ExtractFormula.splitText(input);
        return calculate(inputs);
    }

    private static void validate(String input) {
        Objects.requireNonNull(input, "입력값은 null 일 수 없습니다.");
        if (input.isBlank()) {
            throw new IllegalArgumentException("입력값은 빈 문자열일 수 없습니다.");
        }
    }

    private static int calculate(List<String> inputs) {
        int baseNumber = getNumber(inputs.get(BASE_NUMBER_INDEX));
        int length = inputs.size();
        for (int i = 1; i < length - 1; i++) {
            String operator = inputs.get(i);
            int targetNumber = getNumber(inputs.get(++i));
            baseNumber = calculate(baseNumber, operator, targetNumber);
        }
        return baseNumber;
    }

    private static int getNumber(String text) {
        return Integer.parseInt(text);
    }

    private static int calculate(int baseNumber, String operator, int targetNumber) {
        return OperatorFactory.get(operator).calculate(baseNumber, targetNumber);
    }
}
