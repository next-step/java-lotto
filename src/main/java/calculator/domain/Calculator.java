package calculator.domain;

import calculator.util.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Calculator {
    private final Stack<Operator> operators;
    private final Stack<Integer> operands;

    public Calculator() {
        operators = new Stack<>();
        operands = new Stack<>();
    }

    private static boolean validateInput(List<String> inputList) {
        return inputList.size() % 2 == 1;
    }

    public void insert(String input) {
        List<String> inputList = StringUtils.split(input);
        Collections.reverse(inputList);
        if (!validateInput(inputList)) {
            throw new IllegalArgumentException("입력값과 연산자의 수가 맞지 않습니다.");
        }
        inputList.forEach(this::pushInput);
    }

    private void pushInput(String input) {
        if (operands.size() < operators.size() + 1) {
            operands.push(parseOperand(input));
            return;
        }
        operators.push(parseOperator(input));
    }

    private int parseOperand(String input) {
        return StringUtils.parse(input);
    }

    private Operator parseOperator(String input) {
        return Operator.of(input);
    }

    public int calculate() {
        while (!operators.isEmpty()) {
            calculateOneCycle();
        }
        return operands.pop();
    }

    private void calculateOneCycle() {
        Operator operator = operators.pop();
        int result = operator.operate(operands.pop(), operands.pop());
        operands.push(result);
    }
}
