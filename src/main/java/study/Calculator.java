package study;

import java.util.function.BinaryOperator;
import study.dto.ExpressionBlock;

public class Calculator {
    private Calculator() {
        throw new IllegalArgumentException("Utility Class");
    }

    public static int execute(Expression input) {
        int sum;
        sum = input.first();
        for (int i = 1; i < input.size(); i += 2) {
            sum = calculate(sum, input.getAsExpressionBlock(i));
        }
        return sum;
    }
    private static int calculate(int sum, ExpressionBlock expressionBlock) {
        return findOperator(expressionBlock.getOperator()).apply(sum, expressionBlock.getNumber());
    }

    private static BinaryOperator<Integer> findOperator(Operator operator) {
        if (operator == Operator.ADD) {
            return (a, b) -> a + b;
        }
        if (operator == Operator.SUBTRACT) {
            return (a, b) -> a - b;
        }
        if (operator == Operator.MULTIPLY) {
            return (a, b) -> a * b;
        }
        if (operator == Operator.DIVIDE) {
            return (a, b) -> a / b;
        }
        throw new IllegalArgumentException("Wrong operator!");
    }
}
