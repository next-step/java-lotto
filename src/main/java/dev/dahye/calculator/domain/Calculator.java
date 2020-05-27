package dev.dahye.calculator.domain;

import java.util.Collections;
import java.util.List;

public class Calculator {
    private static final Calculator EMPTY_CALCULATOR = new Calculator(Collections.emptyList());
    private final List<String> numbers;

    private Calculator(List<String> numbers) {
        this.numbers = numbers;
    }

    public static Calculator setting(String input) {
        if (input == null || input.isEmpty()) {
            return EMPTY_CALCULATOR;
        }

        Splitter splitter = Splitter.init(input);
        return new Calculator(splitter.split());
    }

    public int sum() {
        int result = 0;

        for (String stringNumber : numbers) {
            int number = getNumber(stringNumber);
            validateMinus(number);
            result += number;
        }

        return result;
    }

    private int getNumber(String stringNumber) {
        try {
            return Integer.parseInt(stringNumber);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자 이외의 값은 계산할 수 없습니다.", e);
        }
    }

    private void validateMinus(int number) {
        if (number < 0) {
            throw new RuntimeException("음수를 계산할 수 없습니다.");
        }
    }
}
