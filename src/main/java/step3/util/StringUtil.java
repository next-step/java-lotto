package step3.util;

import java.util.Arrays;

public class StringUtil {

    private final static String COMMA = ",";

    public static String[] divideNum(String str) {
        return Arrays.stream(str.split(COMMA))
                .map(String::trim)
                .toArray(String[]::new);
    }
}
