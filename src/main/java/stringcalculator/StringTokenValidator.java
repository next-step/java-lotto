package stringcalculator;

public class StringTokenValidator {
    private static final String numberRegex = "\\d+";
    private static final String operatorRegex = "[-+*/]";

    public static boolean isValidToken(String token) {
        return isValidNumberToken(token) || isValidOperatorToken(token);
    }

    public static boolean isValidNumberToken(String token) {
        return token.matches(numberRegex);
    }

    public static boolean isValidOperatorToken(String token) {
        return token.matches(operatorRegex);
    }

    public static void validateNumberToken(String numberToken) {
        if (!isValidNumberToken(numberToken)) {
            throw new IllegalArgumentException("invalid number token");
        }
    }

    public static void validateOperatorToken(String operatorToken) {
        if (!isValidOperatorToken(operatorToken)) {
            throw new IllegalArgumentException("invalid operator token");
        }
    }
}
