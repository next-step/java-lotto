package lotto.util;

import lotto.exception.NotSupportInstanceException;

public class SplitUtil {

    private static final String BLANK_REGEX = "\\s";
    private static final String NOT_BLANK = "";
    private static final String DEFAULT_SEPARATOR = ",";

    private SplitUtil() {
        throw new NotSupportInstanceException();
    }

    public static String[] split(String value) {
        return split(value, DEFAULT_SEPARATOR);
    }

    public static String[] split(String value, String separator) {
        return trim(value).split(separator);
    }

    private static String trim(String value) {
        return value.trim().replaceAll(BLANK_REGEX, NOT_BLANK);
    }
}
