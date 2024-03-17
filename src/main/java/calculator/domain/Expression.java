package calculator.domain;

import java.util.Stack;

public class Expression {
    private static final String SPLIT_DELIMITER = " ";
    private static final int EXPRESSION_ELEMENT_MIN_SIZE = 3;

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

    private boolean hasNoInput(String input) {
        return input == null || input.isBlank();
    }

    private String[] toStringArray(String input) {
        String[] elements = input.split(SPLIT_DELIMITER);
        if (elements.length < EXPRESSION_ELEMENT_MIN_SIZE) {
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

    public int result() {
        int result = operands.pop().value();
        while (hasNextOperation()) {
            Operator operator = operators.pop();
            result = operator.calculate(result, operands.pop().value());
        }

        return result;
    }

    private boolean hasNextOperation() {
        return !operators.isEmpty();
    }

}
