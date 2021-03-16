package step1.domain;

import java.util.Objects;

public class Token {
    private static final String MIN_ERROR_MESSAGE = "0 보다 커야합니다.";
    private static final int MIN_NUMBER = 0;

    private final int token;

    public Token() {
        this.token = 0;
    }

    public Token(String stringToken) {
        this.token = stringToInt(stringToken);
    }

    private int stringToInt(String stringToken) {
        return isMinimumNumberSize(Integer.parseInt(stringToken));
    }

    private int isMinimumNumberSize(int token) {
        if (token < MIN_NUMBER) {
            throw new RuntimeException(MIN_ERROR_MESSAGE);
        }

        return token;
    }

    public int getToken() {
        return this.token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token1 = (Token) o;
        return token == token1.token;
    }

    @Override
    public int hashCode() {
        return Objects.hash(token);
    }
}
