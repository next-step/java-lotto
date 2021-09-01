package lotto.util;

public class StringUtil {

    private static final String COMMA = ",";

    private static final String BLANK = "\\s";
    private static final String EMPTY = "";

    private StringUtil() {
    }

    public static String[] splitByComma(String input) {
        return input.replaceAll(BLANK, EMPTY).split(COMMA);
    }

}
