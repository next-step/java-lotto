package study.calculator;

import java.util.Objects;

public final class Validator {

    private Validator() {}

    public static final String PREFIX_STRATEGY_CONDITION = "//";
    public static final String STRING_WHITESPACE = "";

    public static boolean isSingleLengthAndIsNotNumeric(String text) {
        return text.length() == 1 && !isNumeric(text);
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
