package lotto.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class InputUtil {
    public static final String FORMAT_ERROR_MENT = "입력형식이 올바르지 않습니다.";

    public static Set<Integer> convertToInt(String[] strings) {
        try {
            return Arrays.stream(strings)
                    .map(string -> Integer.parseInt(string.trim()))
                    .collect(Collectors.toSet());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            throw new RuntimeException(FORMAT_ERROR_MENT);
        }
    }

    public static String[] split(String str) {
        return str.split(", ");
    }

    public static String[] split2(String str) {
        return str.split(",");
    }

    public static String[] splitLine(String str) {
        return str.split(System.lineSeparator());
    }
}
