package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SplitUtil {

    private static final String DELIMITER = ",";
    private static final long NUMBER_OF_DELIMITER_STANDARD = 5;

    private SplitUtil() {
    }

    public static List<String> split(String expression) {
        checkDelimiter(expression);
        checkNumberOfDelimiter(expression.split(""));
        return Arrays.stream(expression.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
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
