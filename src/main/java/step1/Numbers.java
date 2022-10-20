package step1;

import step1.operators.Operators;
import step1.operators.operator.Operator;

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

}
