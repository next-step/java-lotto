package calculator.common;

public class CustomSeparatorUsableChecker {

    private static final String CHECKER_PREFIX = "//";
    private static final String CHECKER_POSTFIX = "\\n";
    public static final int CHECKER_STRING_LIMIT = 5;
    public boolean check(String value) {
        if(isNullOrLengthUnderLimit(value)) return false;
        return value.startsWith(CHECKER_PREFIX)
                && CHECKER_POSTFIX.equals(value.substring(3,5));
    }

    private boolean isNullOrLengthUnderLimit(String value) {
        return value == null || value.length() < CHECKER_STRING_LIMIT;
    }
}
