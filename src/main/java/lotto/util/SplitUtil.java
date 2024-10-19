package lotto.util;

import java.util.Arrays;

public class SplitUtil {
    public static final String DELIMITER = ",";

    public static int[] stringToNumbers(String string) {
        return Arrays.stream(string.split(DELIMITER))
                .mapToInt(s -> Integer.parseInt(s.trim()))
                .toArray();
    }
}
