package domain;

import java.util.Deque;

public class Calculator {
    private Calculator() {}

    public static Calculator getInstance() {
        return LazyHolder.instance;
    }

    private static class LazyHolder {
        private static final Calculator instance = new Calculator();
    }

    public int calculate(String text) {
        Deque<Integer> operands = OperandExtractor.getInstance().extractToDeque(text);
        Deque<String> operators = OperatorExtractor.getInstance().extractToDeque(text);
        validate(operands, operators);

        while (!(operands.size() == 1 && operators.isEmpty())) {
            operands.addFirst(calculate(operands.poll(), operands.poll(), operators.poll()));
        }

        return operands.poll();
    }

    public int calculate(int firstOperand, int secondOperand, String operator) {
        switch (operator) {
            case "+":
                return add(firstOperand, secondOperand);
            case "-":
                return subtract(firstOperand, secondOperand);
            case "*":
                return multiple(firstOperand, secondOperand);
            case "/":
                return divide(firstOperand, secondOperand);
            default:
                throw new IllegalArgumentException("지원하지 않는 연산자입니다.");
        }
    }

    public int add(int firstOperand, int secondOperand) {
        return firstOperand + secondOperand;
    }

    public int subtract(int firstOperand, int secondOperand) {
        return firstOperand - secondOperand;
    }

    public int multiple(int firstOperand, int secondOperand) {
        return firstOperand * secondOperand;
    }

    public int divide(int firstOperand, int secondOperand) {
        if (secondOperand == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }

        return firstOperand / secondOperand;
    }

    private void validate(Deque<Integer> operands, Deque<String> operators) {
        if (operands.size() != operators.size() + 1) {
            throw new IllegalArgumentException("연산자 혹은 피연산자가 부족합니다.");
        }
    }
}
