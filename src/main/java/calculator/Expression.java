package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Expression {

    private final List<Token> tokens;

    private static final int FIRST = 0;
    private static final String TOKEN_DELIMITER = " ";

    public Expression(String strExpression) {
        this(
            Arrays.stream(strExpression.split(TOKEN_DELIMITER))
                .map(Token::of)
                .collect(Collectors.toList())
        );
    }

    public Expression(List<Token> tokens) {
        this.tokens = tokens;
    }

    public boolean isSingleToken() {
        return tokens.size() == 1;
    }

    public Operand firstOperand() {
        return Operand.of(tokens.get(FIRST));
    }

    public Expression expressionWithoutLastOperatorAndOperand() {
        return new Expression(tokens.subList(0, tokens.size() - 2));
    }

    public Operator lastOperator() {
        return Operator.of(tokens.get(tokens.size() - 2));
    }

    public Operand lastOperand() {
        return Operand.of(tokens.get(tokens.size() - 1));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Expression that = (Expression) o;
        return Objects.equals(tokens, that.tokens);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tokens);
    }
}
