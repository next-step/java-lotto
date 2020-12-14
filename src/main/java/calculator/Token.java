package calculator;

import java.util.Objects;

public class Token {

    public static final String NUMBER_REGEX = "^[0-9]+$";
    private final String token;
    private final int number;

    public Token(String token) {
        this.token = token;
        if (!this.token.matches(NUMBER_REGEX)) {
            throw new RuntimeException("숫자 이외의 문자는 입력될 수 없습니다.");
        }
        int number = Integer.parseInt(this.token);
        if (number < 0) {
            throw new RuntimeException("음수값은 입력될 수 없습니다.");
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Token token1 = (Token) o;

        return Objects.equals(token, token1.token);
    }

    @Override
    public int hashCode() {
        return token != null ? token.hashCode() : 0;
    }

}
