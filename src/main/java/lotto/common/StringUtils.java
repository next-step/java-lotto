package lotto.common;

public class StringUtils {
    private final static String NUMBER_REGEX = "\\d*";
    public static boolean isNumeric(String str) {
        return str.matches(NUMBER_REGEX);
    }
}
