package domain;

import java.util.Arrays;

public class Calculator {
    private int result = 0;
    private boolean isFirst = true;
    private String lastOperator = "";

    public int calculate(String input) {
        String[] tokens = input.split(" ");

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*")) {
                this.lastOperator = token;
                continue;
            }

            try {
                if (this.isFirst) {
                    handleFirstInteger(Integer.parseInt(token));
                    continue;
                }
                this.result = calculateByOperator(Integer.parseInt(token));
            } catch (NumberFormatException e) {
                throw new NumberFormatException("유효하지 않은 입력입니다. : " + e.getMessage());
            }
        }
        return this.result;
    }

    private int calculateByOperator(int number) {
        if (this.lastOperator.equals("+")) {
            return plus_two_number(this.result, number);
        }

        if (this.lastOperator.equals("-")) {
            return minusTwoNumber(this.result, number);

        }

        if (this.lastOperator.equals("*")) {
            return multiplyTwoNumber(this.result, number);
        }

        throw new IllegalArgumentException("유효한 사칙연산 기호가 아닙니다.");
    }

    private void handleFirstInteger(int number) {
        this.result = number;
        this.isFirst = false;
    }

    private static int multiplyTwoNumber(int currentNumber, int number) {
        return currentNumber * number;
    }

    private static int minusTwoNumber(int currentNumber, int number) {
        return currentNumber - number;
    }

    private static int plus_two_number(int currentNumber, int number) {
        return currentNumber + number;
    }
}
