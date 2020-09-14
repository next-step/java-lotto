package step1.util;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorUtil {

    private static final int CUSTOM_DELIMITER_IDX = 1;
    private static final int OPERANDS_IDX = 2;
    private static final String DEFAULT_DELIMITER = ",|:";

    public static String[] getOperands(String expression) {
        String[] operands = expression.split(DEFAULT_DELIMITER);

        Matcher m = PatternCache.getCustomDelimiterPattern().matcher(expression);
        if (m.find()) {
            String customDelimiter = m.group(CUSTOM_DELIMITER_IDX);
            operands = m.group(OPERANDS_IDX).split(customDelimiter);
        }

        return operands;
    }
}
