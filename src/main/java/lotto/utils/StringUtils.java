package lotto.utils;

public class StringUtils {
    public static final String BLANK = " ";
    public static final String COMMA = ",";

    public static String[] splitByComma(String text) {
        return text.split(COMMA);
    }

}
