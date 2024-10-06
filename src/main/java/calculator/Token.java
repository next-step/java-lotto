package calculator;

import static calculator.Calculator.NUMBER_REGEX;

public class Token {
    private final String token;

    public Token(final String token) {
        this.token = token;
    }

    public int parseNumber() {
        if (!isNumber()) {
            throw new NumberFormatException("숫자형식의 문자열이 아니므로 숫자로 변환이 불가합니다.");
        }

        return Integer.parseInt(token);
    }

    private boolean isNumber() {
        return NUMBER_REGEX.matcher(token).find();
    }

    public Sign sign() {
        return Sign.findSign(token);
    }
}
