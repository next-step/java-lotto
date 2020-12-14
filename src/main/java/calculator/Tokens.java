package calculator;

import java.util.Arrays;

public class Tokens {
    private final Token[] values;

    public Tokens(Token[] values) {
        this.values = values;
    }

    public Tokens() {
        this.values = new Token[0];
    }

    public int sum() {
        int sum = 0;
        for (Token token : values) {
            sum += token.getNumber();
        }
        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tokens tokens = (Tokens) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(values, tokens.values);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(values);
    }
}
