package lotto.util;

import lotto.exception.NotSupportInstanceException;

public class SplitUtil {

    private static final String BLANK_REGEX = "\\s";
    private static final String NOT_BLANK = "";
    private static final String SEPARATOR = ",";

    private SplitUtil() {
        throw new NotSupportInstanceException();
    }

    public static String[] split(String value) {
        return trim(value).split(SEPARATOR);
    }

    private static String trim(String value) {
        return value.trim().replaceAll(BLANK_REGEX, NOT_BLANK);
    }
}
