package calculator.domain;

import static calculator.config.CalculatorExceptionMessage.EXPRESSION_CANNOT_BE_NULL_OR_EMPTY;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

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

        return ((Operand)tokens.peek()).number();
    }

    private boolean isCalculationPossible() {
        return tokens.size() > 1;
    }

    public static Expression from(final String[] values) {
        validateValuesIsNotNullOrEmpty(values);

        final Deque<Token> tokens = Arrays.stream(values)
                .map(Expression::toToken)
                .collect(Collectors.toCollection(ArrayDeque::new));

        return new Expression(tokens);
    }

    private static void validateValuesIsNotNullOrEmpty(final String[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException(EXPRESSION_CANNOT_BE_NULL_OR_EMPTY.message(values));
        }
    }

    private static Token toToken(final String value) {
        return Operator.isOperator(value) ? Operator.from(value) : Operand.from(value);
    }
}
