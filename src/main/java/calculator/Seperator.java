package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Seperator {

    private static final String DELIMITER = " ";
    private static final String OPERATOR = "[+\\-*/]";

    public String[] split(String text) {
        if (text.isBlank()) {
            throw new IllegalArgumentException("Null or Blank");
        }
        return text.split(DELIMITER);
    }

    public boolean isOperator(String text) {
        Matcher m = Pattern.compile(OPERATOR).matcher(text);
        if (m.find()) {
            return true;
        }
        if (!m.find()) {
            throw new IllegalArgumentException("Not a right operator");
        }
        return false;
    }
}
