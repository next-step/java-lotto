package study.step1.domain.dto;

import study.step1.domain.type.Operator;

public class Input {
    private final String[] input;

    public Input(String[] input) {
        validate(input);
        this.input = input;
    }

    private void validate(String[] input) {
        int length = input.length;
        if (!hasDelimiter(length)) {
            throw new IllegalArgumentException("InputError: 입력값 오류(공백 구분 없음)");
        }

        for (int i = 0; i < length; i++) {
            if (i % 2 == 0) {
                isNumeric(input[i]);
            }

            if (i % 2 == 1) {
                isOperator(input[i]);
            }
        }

    }


    private boolean hasDelimiter(int length) {
        return length > 1;
    }

    private void isNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("InputError: 입력값 오류(숫자가 아닌 값)");
        }
    }
    private void isOperator(String s) {
        if (Operator.valueOfCode(s) == null) {
            throw new IllegalArgumentException("InputError: 입력값 오류(사칙연산 기호가 아닌 값)");
        }
    }
}
