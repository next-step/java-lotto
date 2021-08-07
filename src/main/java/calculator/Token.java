package calculator;

public class Token {
    private static final String NOT_VALID_ARGUMENT_EXIST_STATEMENT = "음수 또는 숫자이외 값이 존재합니다";
    private final String token;

    public Token(String token) {
        validateNegativeNumber(token);
        this.token = token;
    }

    private void validateNegativeNumber(String token) {
        if (Integer.parseInt(token) < 0) {
            throw new RuntimeException(NOT_VALID_ARGUMENT_EXIST_STATEMENT);
        }
    }

    public static Token create(String token) {
        return new Token(token);
    }

    public int parseInt() {
        return Integer.parseInt(this.token);
    }

}
