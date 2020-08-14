package calculator.util;

import java.util.List;

public class ValidUtil {
    private ValidUtil() {
        throw new AssertionError();
    }

    public static void validateNumber(List<String> splitNums) {
        if (splitNums.stream().map(Integer::parseInt).filter(integer -> integer < 0).count() > 0) {
            throw new RuntimeException();
        }
    }
}
