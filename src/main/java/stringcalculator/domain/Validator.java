package stringcalculator.domain;


public class Validator {

    private Validator() {

    }

    public static int validatePositiveNumber(String token) {
        final int intToken = validateTypeOfToken(token);
        if (intToken < 0) {
            throw new RuntimeException("[Error]: 양수만 연산 가능합니다.");
        }
        return intToken;
    }

    public static int validateTypeOfToken(final String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[Error]: 숫자만 연산 가능합니다.");
        }
    }
}
