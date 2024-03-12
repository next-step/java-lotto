package calculator;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Expression {

    private final List<Operand> operands;
    private final List<Operator> operators;

    private static final int FIRST = 0;
    private static final int ONE = 1;
    private static final String TOKEN_DELIMITER = " ";

    public Expression(List<Operand> operands, List<Operator> operators) {
        this.operands = operands;
        this.operators = operators;
    }

    public static Expression of(String strExpression) {
        String[] tokens = strExpression.split(TOKEN_DELIMITER);

        List<Operand> operands = extractOperands(tokens);
        List<Operator> operators = extractOperators(tokens);
        return new Expression(operands, operators);
    }

    private static List<Operator> extractOperators(String[] tokens) {
        return IntStream.range(FIRST, tokens.length)
            .filter(Expression::isOdd)
            .mapToObj(i -> Operator.from(tokens[i]))
            .collect(Collectors.toUnmodifiableList());
    }

    private static boolean isOdd(int number) {
        return number % 2 == ONE;
    }

    private static List<Operand> extractOperands(String[] tokens) {
        return IntStream.range(FIRST, tokens.length)
            .filter(Expression::isEven)
            .mapToObj(i -> Operand.from(tokens[i]))
            .collect(Collectors.toUnmodifiableList());
    }

    private static boolean isEven(int number) {
        return number % 2 == FIRST;
    }

    public boolean isSingleToken() {
        return operands.size() == ONE && operators.isEmpty();
    }

    public Operand firstOperand() {
        return operands.get(FIRST);
    }

    public Expression expressionWithoutLastOperatorAndOperand() {
        return new Expression(
            operands.subList(FIRST, operands.size() - ONE),
            operators.subList(FIRST, operators.size() - ONE)
        );
    }

    public Operator lastOperator() {
        return operators.get(operators.size() - ONE);
    }

    public Operand lastOperand() {
        return operands.get(operands.size() - ONE);
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
        return Objects.equals(operands, that.operands) && Objects.equals(operators,
            that.operators);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operands, operators);
    }

    @Override
    public String toString() {
        return "Expression{" +
            "operands=" + operands +
            ", operators=" + operators +
            '}';
    }
}
