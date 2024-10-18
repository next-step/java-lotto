package lotto.util;

import java.util.Arrays;

public class SplitUtil {
    public static final String DELIMITER = ",";

    public static Integer[] stringToNumbers(String string) {
        return Arrays.stream(string.split(DELIMITER))
                .map(s -> Integer.parseInt(s.trim()))
                .toArray(Integer[]::new);
    }
}
