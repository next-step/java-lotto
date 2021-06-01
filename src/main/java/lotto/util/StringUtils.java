package lotto.util;

import java.text.DecimalFormat;
import java.util.Arrays;

public class StringUtils {
    private static final String DEFAULT_REGEX = "\\s*,\\s*";
    private static final DecimalFormat MONEY_FORMAT = new DecimalFormat("###,###,###,###");

    private StringUtils() {
        throw new AssertionError();
    }

    public static int[] csvToIntArray(String source) {
        return csvToIntArray(source, DEFAULT_REGEX);
    }

    public static int[] csvToIntArray(String source, String regex) {
        return Arrays.stream(source.trim().split(regex))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static String toMoneyFormat(double money) {
        return MONEY_FORMAT.format(money);
    }

}
