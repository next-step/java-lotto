package calculator;

import java.util.LinkedList;
import java.util.List;

public class Calculator {
    public Integer performSequentialArithmetics(List<Integer> operands, List<Operator> operators) {
        var operandQueue = new LinkedList<>(operands);
        var operatorQueue = new LinkedList<>(operators);

        var accumulator = operandQueue.pop();
        while (!operandQueue.isEmpty()) {
            var currentOperator = operatorQueue.pop();
            var currentOperand = operandQueue.pop();
            accumulator = currentOperator.perform(accumulator, currentOperand);
        }
        return accumulator;
    }
}
