package calculator;

public class Expression {
    private final Tokens tokens;

    private Expression(Tokens tokens) {
        this.tokens = tokens;
    }

    static Expression from(String text) {
        Tokens tokens = Tokens.from(text);
        return new Expression(tokens);
    }

    int value() {
        return tokens.value().toInt();
    }
}
