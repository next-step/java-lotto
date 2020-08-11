package calculator;

import java.util.Arrays;

public class StringCalculator {
    private static final String NEGATIVE_NOT_VALID_MESSAGE;
    private static final int ZERO = 0;

    static {
        NEGATIVE_NOT_VALID_MESSAGE = "음수는 유효하지 않습니다.";
    }

    private StringCalculator() {}

    public static int calculate(String text) {
        if (isEmptyText(text)) {
            return ZERO;
        }
        return sum(Splitter.splitByDelimiter(text));
    }

    private static boolean isEmptyText(String text) {
        return text == null || text.isEmpty();
    }

    private static int stringToInt(String text) {
        int number = Integer.parseInt(text);
        if (number < ZERO) {
            throw new RuntimeException(NEGATIVE_NOT_VALID_MESSAGE);
        }
        return number;
    }

    private static int sum(String[] texts) {
        return Arrays.stream(texts)
                .mapToInt(StringCalculator::stringToInt)
                .reduce(ZERO, Integer::sum);
    }
}
