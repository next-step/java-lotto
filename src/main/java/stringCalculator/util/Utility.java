package stringCalculator.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {
    private static final String SPLIT_COMMA_COLON;
    private static final String SPLIT_BY_CUSTOM_DELIMITER;

    static {
        SPLIT_COMMA_COLON = ",|:";
        SPLIT_BY_CUSTOM_DELIMITER = "//(.)\n(.*)";
    }

    public static boolean isEquationEmpty(String equation) {
        return equation == null || equation.isEmpty();
    }

    public String[] splitEquation(String equation) {
        Matcher m = Pattern.compile(SPLIT_BY_CUSTOM_DELIMITER).matcher(equation);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return equation.split(SPLIT_COMMA_COLON);
    }

}
