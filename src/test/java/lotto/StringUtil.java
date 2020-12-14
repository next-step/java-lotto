package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringUtil {

    private static final String INCLUDE_NEGATIVE_VALUE_ERROR = "문자열에 음수값이 포함되어 있습니다.";
    private static final int ZERO = 0;

    private StringUtil() {
    }

    public static List<Integer> textToInt(String[] texts) {
        return Stream.of(texts)
                .map(text -> validatePositiveNumber(text))
                .collect(Collectors.toList());
    }

    public static int validatePositiveNumber(String text) {
        int number = Integer.parseInt(text);
        if(number < ZERO) {
            throw new RuntimeException(INCLUDE_NEGATIVE_VALUE_ERROR);
        }
        return number;
    }
}
