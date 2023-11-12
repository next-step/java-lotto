package utils;

public class StringUtils {

    private static final String PATTERN = " ";

    private StringUtils() { //인스턴스화 방지
    }

    public static String[] splitByPattern(String input) {
        return input.split(PATTERN);
    }
}
