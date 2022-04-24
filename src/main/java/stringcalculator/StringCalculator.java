package stringcalculator;


import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class StringCalculator {

    public static final String DELIMITER = " ";
    public static final int INPUT_LENGTH_LOWER_BOUND = 3;
    public static final int EVEN_CHECK_VALUE = 2;
    public static final int BASE_NUMBER_INDEX = 0;
    public static final int IS_DIVIDED = 0;
    public static final String PLUS = "+";
    public static final String MINUS = "-";
    public static final String DIVIDE = "/";
    public static final String MULTIPLE = "*";

    private StringCalculator() {
        throw new AssertionError();
    }

    public static int calculate(String input) {
        validate(input);
        List<String> inputs = split(input);
        validate(inputs);
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

    private static void validate(List<String> inputs) {
        if (inputs.size() < INPUT_LENGTH_LOWER_BOUND) {
            throw new IllegalArgumentException("입력값은 공백으로 구분하여 3개 이상이어야 합니다. inputs : " + inputs);
        }
        if (inputs.size() % EVEN_CHECK_VALUE == IS_DIVIDED) {
            throw new IllegalArgumentException("입력값은 계산가능한 형태로 주어져야 합니다. inputs : " + inputs);
        }
    }

    private static int calculate(List<String> inputs) {
        int baseNumber = Integer.parseInt(inputs.get(BASE_NUMBER_INDEX));
        int length = inputs.size();
        for (int i = 1; i < length - 1; i++) {
            String operator = inputs.get(i);
            int targetNumber = Integer.parseInt(inputs.get(++i));
            baseNumber = calculate(baseNumber, operator, targetNumber);
        }
        return baseNumber;
    }

    private static int calculate(int baseNumber, String operator, int targetNumber) {
        if (PLUS.equals(operator)) {
            return baseNumber + targetNumber;
        }
        if (MINUS.equals(operator)) {
            return baseNumber - targetNumber;
        }
        if (DIVIDE.equals(operator)) {
            return baseNumber / targetNumber;
        }
        if (MULTIPLE.equals(operator)) {
            return baseNumber * targetNumber;
        }
        throw new IllegalArgumentException("올바르지 않은 연산자입니다. : " + operator);
    }
}
