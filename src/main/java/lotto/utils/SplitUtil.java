package lotto.utils;

import java.util.Arrays;

public class SplitUtil {

    private static final String DELIMITER = ",";
    private static final long NUMBER_OF_DELIMITER_STANDARD = 5;

    private SplitUtil() {
    }

    public static String[] split(String expression) {
        checkDelimiter(expression);
        checkNumberOfDelimiter(expression.split(""));
        return expression.split(DELIMITER);
    }

    private static void checkDelimiter(String expression) {
        if (!expression.contains(DELIMITER)) {
            throw new IllegalArgumentException("구분자가 \",\"인지 확인해주세요.");
        }
    }

    private static void checkNumberOfDelimiter(String[] expression) {
        long count = Arrays.stream(expression)
                .filter(letter -> letter.equals(DELIMITER))
                .count();

        if (count != NUMBER_OF_DELIMITER_STANDARD) {
            throw new IllegalArgumentException("구분자 \",\"의 개수가 5개인지 확인해주세요.");
        }
    }
}
