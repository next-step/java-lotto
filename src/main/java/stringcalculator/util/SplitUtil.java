package stringcalculator.util;

import java.util.Arrays;
import java.util.List;

public class SplitUtil {

    public static final String SPACE = " ";
    public static final String NOT_ALLOW_BELOW_THREE_OR_LIST_SIZE_EVEN_NUMBER = "잘못된 문자열을 입력했습니다.(공백 2개 이상, 숫자 연산자 숫자(2 * 3) 형태)";
    public static final int MIN_SIZE = 3;
    public static final int EVEN_CHECK_NUMBER = 2;
    public static final int ZERO = 0;

    public static List<String> split(final String input) {
        List<String> result = Arrays.asList(input.trim()
                .split(SPACE));

        if (isInvalidateSize(result.size())) {
            throw new IllegalArgumentException(NOT_ALLOW_BELOW_THREE_OR_LIST_SIZE_EVEN_NUMBER);
        }

        return result;
    }

    private static boolean isInvalidateSize(int size) {
        return size < MIN_SIZE ||
                size % EVEN_CHECK_NUMBER == ZERO;
    }
}
