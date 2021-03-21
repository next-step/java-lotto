package lotto.utils;

public class SplitUtil {

    public static final String DELIMITER = ",";

    private SplitUtil() {
    }

    public static String[] split(String expression) {
        checkDelimiter(expression);
        return expression.split(DELIMITER);
    }

    private static void checkDelimiter(String expression) {
        if (!expression.contains(DELIMITER)) {
            throw new IllegalArgumentException("구분자가 \",\"인지 확인해주세요.");
        }
    }
}
