package calculator.domain;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Expression {

    private final Deque<Integer> operands;
    private final Deque<String> operators;

    private Expression(Deque<Integer> operands, Deque<String> operators) {
        this.operands = operands;
        this.operators = operators;
    }

    public static Expression from(List<Integer> operands, List<String> operators) {
        return new Expression(listToDeque(operands), listToDeque(operators));
    }

    private static <T> Deque<T> listToDeque(List<T> list) {
        Deque<T> deque = new ArrayDeque<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            deque.push(list.get(i));
        }
        return deque;
    }

    public Integer getCalculateResult() {
        while (isNotCalculated()) {
            int operationResult = getOperation().calculate();
            addOperand(operationResult);
        }
        return operands.pop();
    }

    private boolean isNotCalculated() {
        return !operators.isEmpty();
    }

    private Operation getOperation() {
        Integer operand1 = operands.pop();
        Integer operand2 = operands.pop();
        String operator = operators.pop();
        return Operation.of(operand1, operand2, operator);
    }

    private void addOperand(Integer operand) {
        operands.push(operand);
    }
}
