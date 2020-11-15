package Calculator;

import java.util.Arrays;
import java.util.Objects;

public class StringAddCalculator {

    private static final int ZERO = 0;
    private static final String EMPTY_VALUE = "";

    private static final String MESSAGE_INVALID_INPUT = "입력값은 0이상의 숫자여야 합니다.";
    private static final String MESSAGE_UTILITY_CLASS = "Utility class";

    private StringAddCalculator() {
        throw new IllegalStateException(MESSAGE_UTILITY_CLASS);
    }

    public static int splitAndSum(String input) {
        if (isValidInput(input)) {
            return ZERO;
        }

        return sum(SplitUtils.split(input));
    }

    private static boolean isValidInput(String input) {
        return Objects.isNull(input) || input.equals(EMPTY_VALUE);
    }

    public static int sum(String[] list) {
        return Arrays.stream(list)
                .mapToInt(StringAddCalculator::parseInt)
                .sum();
    }

    private static int parseInt(String value) {
        int num = Integer.parseInt(value);
        if (num < ZERO) {
            throw new IllegalArgumentException(MESSAGE_INVALID_INPUT);
        }
        return num;
    }
}
