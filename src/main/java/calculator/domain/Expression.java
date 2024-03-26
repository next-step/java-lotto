package calculator.domain;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

import calculator.domain.parser.Parser;

public class Expression {

    private final Deque<Token> tokens;

    private Expression(final Deque<Token> tokens) {
        this.tokens = tokens;
    }

    public int calculate() {
        while (isCalculationPossible()) {
            final Operand leftOperand = (Operand)tokens.pollFirst();
            final Operator operator = (Operator)tokens.pollFirst();
            final Operand rightOperand = (Operand)tokens.pollFirst();

            final Operand result = operator.calculate(leftOperand, rightOperand);
            tokens.offerFirst(result);
        }

        final Operand result = (Operand)tokens.peek();

        return result.number();
    }

    private boolean isCalculationPossible() {
        return tokens.size() > 1;
    }

    public static Expression of(final String text, final Parser parser) {
        return new Expression(toTokens(parser.parse(text)));
    }

    private static ArrayDeque<Token> toTokens(final String[] values) {
        return Arrays.stream(values)
                .map(Expression::toToken)
                .collect(Collectors.toCollection(ArrayDeque::new));
    }

    private static Token toToken(final String value) {
        return Operator.isOperator(value) ? Operator.from(value) : Operand.from(value);
    }
}
