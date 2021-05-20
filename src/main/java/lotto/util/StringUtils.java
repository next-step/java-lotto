package lotto.util;

import java.util.Arrays;

public class StringUtils {
    private static final String DEFAULT_REGEX = "\\s*,\\s*";

    public static int[] csvToIntArray(String source) {
        return csvToIntArray(source, DEFAULT_REGEX);
    }

    public static int[] csvToIntArray(String source, String regex) {
        return Arrays.stream(source.trim().split(regex))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

}
