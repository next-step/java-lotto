package step3.utils;

public class ValidationUtils {
    private static final String MATCH_PRICE = "^[0-9\\,]*$";

    private ValidationUtils() {
        throw new AssertionError();
    }

    public static boolean isNullCheck(String winningNumbers) {
        if (winningNumbers == null || winningNumbers.isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean validWinningNumbersComma(String winningNumbers) {
        if (!winningNumbers.matches(MATCH_PRICE)) {
            return false;
        }
        return true;
    }

    public static boolean validWinningNumbersDigit(int size) {
        if (size != 6) {
            return false;
        }
        return true;
    }
}
