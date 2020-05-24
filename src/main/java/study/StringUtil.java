package study;

public class StringUtil {

    private StringUtil() {}

    public static boolean isNullOrEmpty(String s) {
        return s == null || s.isEmpty();
    }

    public static boolean isSingleWord(String s) {
        return s.length() == 1;
    }
}
