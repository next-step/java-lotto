package step1.arithmeticExpression.operators;

import step1.arithmeticExpression.operators.operator.Operator;

import java.util.Objects;
import java.util.Queue;

public class Operators {

    private final ExpressionAsOperators expressionAsOperators;

    public Operators(ExpressionAsOperators expressionAsOperators) {
        this.expressionAsOperators = expressionAsOperators;
    }

    public Queue<Operator> operators() {
        return expressionAsOperators.operators();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operators operators = (Operators) o;
        return Objects.equals(expressionAsOperators, operators.expressionAsOperators);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expressionAsOperators);
    }
}
