package stringcalculator;

public class StringUtils {

    private static final String DELIMITER = " ";
    private static final String NUMBER_MATCHER = "\\d+";

    public static String[] split(String str) {
        return str.trim().split(DELIMITER);
    }

    public static boolean isNumber(String s) {
        return s.matches(NUMBER_MATCHER);
    }

    public static boolean isOperator(String s) {
        return !isNumber(s);
    }
}
