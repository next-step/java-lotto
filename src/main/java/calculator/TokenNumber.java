package calculator;

public class TokenNumber {

    private final long value;

    TokenNumber(long value) {
        if (value < 0) {
            throw new IllegalArgumentException(String.format("%s is invalid format", value));
        }

        this.value = value;
    }

    static TokenNumber of(String token) {
        try {
            return new TokenNumber(Integer.parseInt(token));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("%s is invalid format", token));
        }
    }

    long getValue() {
        return value;
    }
}
