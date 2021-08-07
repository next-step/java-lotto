package lotto;

public class StringUtil {
    private static final String DELIMITER = ",";

    public static String[] split(String s) {
        return s.split(DELIMITER);
    }
}
