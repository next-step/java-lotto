package step1;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Expression {

    private final Stack<String> operands;
    private final Stack<String> operators;

    private Expression(Stack<String> operands, Stack<String> operators) {
        this.operands = operands;
        this.operators = operators;
    }

    public static Expression from(List<String> operands, List<String> operators) {
        return new Expression(listToStack(operands), listToStack(operators));
    }

    private static Stack<String> listToStack(List<String> list) {
        Stack<String> stack = new Stack<>();
        for(int i = list.size() - 1; i >= 0; i--) {
            stack.push(list.get(i));
        }
        return stack;
    }

    public Operation getOperation() {
        String operand1 = operands.pop();
        String operand2 = operands.pop();
        String operator = operators.pop();
        return new Operation(operand1, operand2, operator);
    }

    public void addOperand(String operand) {
        operands.push(operand);
    }

    public boolean isNotCalculated() {
        return !operators.empty();
    }

    public String getCalculateResult() {
        return operands.pop();
    }
}
