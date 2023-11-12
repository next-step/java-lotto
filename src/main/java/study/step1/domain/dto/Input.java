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
        int length = input.length;
        if (!hasDelimiter(length)) {
            throw new IllegalArgumentException("InputError: 입력값 오류(공백 구분 없음)");
        }

        for (int i = 0; i < length; i++) {
            addValidNumber(input, i);
            addValidOperator(input, i);
        }

        if (!isValidNumbers()) {
            throw new IllegalArgumentException();
        }
        if (!isValidOperators()) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasDelimiter(int length) {
        return length > 1;
    }

    private void addValidNumber(String[] input, int i) {
        if (isIndexOdd(i)) {
            numbers.add(isNumeric(input[i]));
        }
    }

    private static boolean isIndexOdd(int i) {
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

    private static boolean isIndexEven(int i) {
        return i % 2 == 1;
    }

    private Operator isOperator(String s) {
        Operator operator = Operator.valueOfCode(s);
        if (operator == null) {
            throw new IllegalArgumentException("InputError: 입력값 오류(사칙연산 기호가 아닌 값)");
        }
        return operator;
    }

    private boolean isValidNumbers() {
        return !numbers.isEmpty();
    }

    private boolean isValidOperators() {
        return !operators.isEmpty();
    }

    public Queue<Integer> getNumbers() {
        return numbers;
    }

    public Queue<Operator> getOperators() {
        return operators;
    }
}
