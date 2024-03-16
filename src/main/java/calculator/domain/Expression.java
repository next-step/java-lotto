package calculator.domain;

import java.util.Stack;

public class Expression {
    private static final String SPLIT_DELIMITER = " ";

    private final Stack<Operand> operands;
    private final Stack<Operator> operators;

    public Expression(String input) {
        if (hasNoInput(input)) {
            throw new IllegalArgumentException("연산식이 입력되지 않았습니다.");
        }

        String[] elements = toStringArray(input);

        operands = toOperandStack(elements);
        operators = toOperatorStack(elements);
    }

    public int result() {
        while (hasNextOperation()) {
            Operator operator = operators.pop();
            int result = operator.calculate(operands.pop().value(), operands.pop().value());
            operands.push(new Operand(result));
        }

        return operands.pop().value();
    }

    private boolean hasNoInput(String input) {
        return input == null || input.isBlank();
    }

    private String[] toStringArray(String input) {
        String[] elements = input.split(SPLIT_DELIMITER);
        if (elements.length < 3) {
            throw new IllegalArgumentException("올바른 연산식을 입력하세요.");
        }

        return elements;
    }

    private Stack<Operand> toOperandStack(String[] elements) {
        Stack<Operand> operandStack = new Stack<>();

        for (int i = elements.length - 1; i >= 0 ; i = i - 2) {
            operandStack.push(new Operand(elements[i]));
        }

        return operandStack;
    }

    private Stack<Operator> toOperatorStack(String[] elements) {
        Stack<Operator> operatorStack = new Stack<>();

        for (int i = elements.length - 2; i >= 0 ; i = i - 2) {
            operatorStack.push(Operator.of(elements[i]));
        }

        return operatorStack;
    }

    private boolean hasNextOperation() {
        return !operators.isEmpty();
    }

}
