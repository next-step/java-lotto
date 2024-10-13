package lotto.util;

import java.util.Arrays;

public class SplitUtil {

    public static final String COMMA = ",";

    public static Integer[] stringToNumbers(String string) {
        return Arrays.stream(string.split(COMMA))
                .map(s -> Integer.parseInt(s.trim()))
                .toArray(Integer[]::new);
    }
}
