package study.step1.domain.dto;

import java.util.LinkedList;
import java.util.Queue;

import study.step1.domain.type.Operator;

public class Input {

    private final Queue<Integer> numbers = new LinkedList<>();
    private final Queue<Operator> operators = new LinkedList<>();

    public Input(String[] input) {
        validate(input);
    }

    private void validate(String[] input) {
        for (int i = 0; i < input.length; i++) {
            addValidNumber(input, i);
            addValidOperator(input, i);
        }
    }

    private void addValidNumber(String[] input, int i) {
        if (isIndexOdd(i)) {
            numbers.add(isNumeric(input[i]));
        }
    }

    private boolean isIndexOdd(int i) {
        return i % 2 == 0;
    }

    private int isNumeric(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("InputError: 입력값 오류(숫자가 아닌 값)");
        }
    }

    private void addValidOperator(String[] input, int i) {
        if (isIndexEven(i)) {
            operators.add(isOperator(input[i]));
        }
    }

    private boolean isIndexEven(int i) {
        return i % 2 == 1;
    }

    private Operator isOperator(String s) {
        Operator operator = Operator.valueOfCode(s);
        if (operator == null) {
            throw new IllegalArgumentException("InputError: 입력값 오류(사칙연산 기호가 아닌 값)");
        }
        return operator;
    }

    public Queue<Integer> getNumbers() {
        return numbers;
    }

    public Queue<Operator> getOperators() {
        return operators;
    }
}
