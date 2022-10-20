package step1.numbers;

import step1.operators.Operators;
import step1.operators.operator.Operator;

import java.util.Objects;
import java.util.Queue;

public class Numbers {

    private final ExpressionAsNumbers expressionAsNumbers;

    public Numbers(ExpressionAsNumbers expressionAsNumbers) {
        this.expressionAsNumbers = expressionAsNumbers;
    }


    public int calculatedResult(Operators operators) {
        Queue<Operator> arithmeticOperators = operators.operators();

        return expressionAsNumbers.numbers()
                .stream()
                .reduce((operand, anotherOperand) -> arithmeticOperators.poll().executedResult(operand, anotherOperand))
                .orElse(0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Numbers numbers = (Numbers) o;
        return Objects.equals(expressionAsNumbers, numbers.expressionAsNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expressionAsNumbers);
    }
}
