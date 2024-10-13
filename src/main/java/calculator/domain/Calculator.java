package calculator.domain;

import java.util.Iterator;
import java.util.function.IntBinaryOperator;

public class Calculator {

    private Calculator() {};

    public static Integer calculate(Expression expression) {
        if (expression == null) {
            throw new IllegalArgumentException("표현식을 확인해 주세요.");
        }

        Iterator<Integer> operands = expression.getOperands();
        Iterator<IntBinaryOperator> operators = expression.getOperators();

        Integer initial = operands.next();

        Integer result = initial;
        while (operands.hasNext()) {
            IntBinaryOperator operator = operators.next();
            result = operator.applyAsInt(result, operands.next());
        }

        return result;
    }
}
