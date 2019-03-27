package lotto.util;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputUtil {
    public static final String FORMAT_ERROR_MENT = "입력형식이 올바르지 않습니다.";

    public static Set<Integer> convertToInt(String[] strings) {
        try {
            return Stream.of(strings)
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toSet());
        } catch (NumberFormatException e) {
            throw new RuntimeException(FORMAT_ERROR_MENT);
        }
    }

    public static String[] split(String str) {
        return str.split(", ");
    }
}
