package lotto.util;

import java.util.Arrays;

public class StringUtils {

    public static int[] csvToIntArray(String source) {
        return csvToIntArray(source, "\\s*,\\s*");
    }

    public static int[] csvToIntArray(String source, String regex) {
        return Arrays.stream(source.trim().split(regex))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

}
