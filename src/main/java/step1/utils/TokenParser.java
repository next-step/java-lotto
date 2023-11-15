package step1.utils;

public class TokenParser {

    public static int tokenParseInteger(final String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 피연산자가 아닙니다.");
        }
    }

}
