package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SplitUtil {

    private static final String DELIMITER = ",";

    private SplitUtil() {
    }

    public static List<String> splitByComma(String expression) {
        checkDelimiter(expression, DELIMITER);
        return Arrays.stream(expression.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private static void checkDelimiter(String expression, String delimiter) {
        if (!expression.contains(delimiter)) {
            throw new IllegalArgumentException(String.format("구분자가 \"%s\"인지 확인해주세요.", delimiter));
        }
    }
}
