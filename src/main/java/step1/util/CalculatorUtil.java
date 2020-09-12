package step1.util;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorUtil {

    private static final String DEFAULT_DELIMITER = ",|:";

    public static Optional<String[]> getOperands(String expression) {
        StringBuilder sb = new StringBuilder(DEFAULT_DELIMITER);
        String[] operands = expression.split(DEFAULT_DELIMITER);

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(expression);
        if (m.find()) {
            String customDelimiter = m.group(1);
            sb.append("|" + customDelimiter);
            operands = m.group(2).split(sb.toString());
        }

        return Optional.of(operands);
    }
}
