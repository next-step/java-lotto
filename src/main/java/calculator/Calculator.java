package calculator;

import java.util.LinkedList;

public class Calculator {
    public Integer evaluate(Expression expression) {
        var operandQueue = new LinkedList<>(expression.getOperands());
        var operatorQueue = new LinkedList<>(expression.getOperators());

        var accumulator = operandQueue.pop();
        while (!operandQueue.isEmpty()) {
            var currentOperator = operatorQueue.pop();
            var currentOperand = operandQueue.pop();
            accumulator = currentOperator.perform(accumulator, currentOperand);
        }
        return accumulator;
    }
}
