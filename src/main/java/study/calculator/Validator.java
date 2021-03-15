package study.calculator;

import java.util.Objects;

public final class Validator {

    private Validator() {}

    public static final String PREFIX_STRATEGY_CONDITION = "//";

    public static boolean isNotNumericOrIsNegativeNumber(String number) {
        return !isNumeric(number) || isNegativeNumber(number);
    }
    public static boolean isNegativeNumber(String text) {
        return Integer.parseInt(text) < 0;
    }

    public static boolean isNotNullAndIsBlank(String text) {
        return Objects.isNull(text) || text.trim().isEmpty();
    }

    public static boolean isNumeric(String text) {
        try {
            Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
