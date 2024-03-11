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
        int startIndex = 0;
        int lastOperatorIndex = tokens.size() - 2;
        return new Expression(tokens.subList(startIndex, lastOperatorIndex));
    }

    public Operator lastOperator() {
        int lastOperatorIndex = tokens.size() - 2;
        return Operator.of(tokens.get(lastOperatorIndex));
    }

    public Operand lastOperand() {
        int lastOperandIndex = tokens.size() - 1;
        return Operand.of(tokens.get(lastOperandIndex));
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
