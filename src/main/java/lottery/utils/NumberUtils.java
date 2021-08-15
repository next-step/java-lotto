package lottery.utils;

import java.util.Objects;
import java.util.regex.Pattern;

public class NumberUtils {

    private static final String NON_NULL = "입력값은 null 일 수 없습니다";
    private static final String NOT_NUMBER = "숫자가 아닙니다 -> ";
    private static final String LESS_THAN_ZERO = "입력값은 0 보다 커야 합니다 -> ";
    private static final int ZERO = 0;
    private static final Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static void requirePositiveNumber(final int number) {
        if (number < ZERO) {
            throw new IllegalArgumentException(LESS_THAN_ZERO + number);
        }
    }

    public static void requireNumber(final String number) {
        if (!NUMBER_PATTERN.matcher(number).matches()) {
            throw new IllegalArgumentException(NOT_NUMBER + number);
        }
    }

    public static void requireNonNull(final String number) {
        if (Objects.isNull(number)) {
            throw new IllegalArgumentException(NON_NULL);
        }
    }
}
