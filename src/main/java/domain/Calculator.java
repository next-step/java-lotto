package domain;

public class Calculator {
    private int result = 0;
    private boolean isFirst = true;
    private String lastOperator = "";

    public int calculate(String input) {
        String[] tokens = input.split(" ");

        try {
            for (String token : tokens) {
                if (this.isFirst) {
                    handleFirstInteger(Integer.parseInt(token));
                    continue;
                }

                if (validateOperator(token)) {
                    continue;
                }
                this.result = calculateByOperator(Integer.parseInt(token));
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("유효하지 않은 입력입니다. : " + e.getMessage());
        }
        return this.result;
    }

    private boolean validateOperator(String token) {
        if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
            changeOperator(token);
            return true;
        }
        return false;
    }

    private void changeOperator(String token) {
        this.lastOperator = token;
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

        if (this.lastOperator.equals("/")) {
            return divideTwoNumber(this.result, number);
        }

        throw new IllegalArgumentException("유효한 사칙연산 기호가 아닙니다.");
    }

    private int divideTwoNumber(int result, int number) {
        if (number == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return result / number;
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
