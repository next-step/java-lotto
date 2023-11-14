package calculator;

import java.util.regex.Pattern;

public class Seperator {

    private static final String DELIMITER = " ";
    private static final String OPERATOR = "[+\\-*/]";
    private static final Pattern BASIC = Pattern.compile(OPERATOR);

    public String[] split(String text) {
        if (text.isBlank()) {
            throw new IllegalArgumentException("Null or Blank");
        }
        return text.split(DELIMITER);
    }

    public boolean isOperator(String text) {
        if (BASIC.matcher(text).find()) {
            return true;
        }
        if (!BASIC.matcher(text).find()) {
            throw new IllegalArgumentException("Not a right operator");
        }
        return false;
    }
}
