package step2.util;

import step2.exception.EmptyStringException;
import step2.exception.NotNumericException;

import java.math.BigDecimal;
import java.util.regex.Pattern;

public class BigDecimalUtil {

    private static final Pattern NUMERIC_PATTERN = Pattern.compile("[0-9]+");

    public static BigDecimal stringToBigDecimal(String text) {
        validate(text);
        return new BigDecimal(text);
    }

    private static void validate(String text) {
        validateEmpty(text);
        validateNumeric(text);
    }

    private static void validateEmpty(String text) {
        if (text == null || text.isEmpty()) {
            throw new EmptyStringException();
        }
    }

    private static void validateNumeric(String text) {
        if (!isMatch(text)) {
            throw new NotNumericException();
        }
    }

    private static boolean isMatch(String text) {
        return NUMERIC_PATTERN.matcher(text).matches();
    }

}
