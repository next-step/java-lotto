package step1.arithmeticExpression.numbers;

import step1.arithmeticExpression.operators.Operators;
import step1.arithmeticExpression.operators.operator.Operator;

import java.util.Objects;
import java.util.Queue;

public class Numbers {

    private final ExpressionAsNumbers expressionAsNumbers;

    public Numbers(ExpressionAsNumbers expressionAsNumbers) {
        this.expressionAsNumbers = expressionAsNumbers;
    }


    public int calculatedResult(Operators operators) {
        verifyValidOperators(operators);

        Queue<Operator> arithmeticOperators = operators.operators();

        return expressionAsNumbers.numbers()
                .stream()
                .reduce((operand, anotherOperand) -> arithmeticOperators.poll().executedResult(operand, anotherOperand))
                .orElse(0);
    }

    private void verifyValidOperators(Operators operators) {
        int numbersSize = expressionAsNumbers.numbers().size();
        int operatorsSize = operators.operators().size();

        if (numbersSize - operatorsSize != 1) {
            throw new IllegalArgumentException("유효한 연산자가 아닙니다.");
        }
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
