package step1;

public class NumberFormatValidator {
    private NumberFormatValidator() {
        throw new AssertionError();
    }

    public static boolean isInvalid(final String symbol) {
        return !isValid(symbol);
    }

    public static boolean isValid(final String symbol) {
        for (char c : symbol.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
