package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Tokens {

    private List<Token> tokens;

    private static final String TOKEN_DELIMITER = " ";
    private static final int ONE = 1;
    private static final int FIRST = 0;

    public Tokens(String expression) {
        this(
            Arrays.stream(expression.split(TOKEN_DELIMITER))
                .map(Token::of)
                .collect(Collectors.toList())
        );
    }

    public Tokens(List<Token> tokens) {
        this.tokens = tokens;
    }

    public Expression firstExpression() {
        Operand left = Operand.of(tokens.get(FIRST));
        Operator operator = Operator.of(tokens.get(1));
        Operand right = Operand.of(tokens.get(2));
        return new Expression(operator, left, right);
    }

    public void replaceFirstExpressionWithResult(int result) {
        tokens = tokens.subList(3, tokens.size());
        tokens.add(FIRST, new Operand(result));
    }

    public boolean hasResult() {
        return tokens.size() == 1;
    }

    public int result() {
        return Operand.of(tokens.get(0)).value();
    }
}
