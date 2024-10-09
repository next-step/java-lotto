package domain;

public class Calculator {
    private int result = 0;
    private int tokenCount = 0;
    private String lastOperator = "";

    public int calculate(String input) {
        validateInput(input);
        String[] tokens = input.split(" ");

        for (String token : tokens) {
            tokenCount += 1;

            if (isFirstOrder()) {
                this.result = handleFirstInteger(token);
                continue;
            }

            if (isOrderOperator()) {
                handleOperator(token);
                continue;
            }

            this.result = calculateByOperator(token);
        }
        return this.result;
    }

    private boolean isOrderOperator() {
        return tokenCount % 2 == 0;
    }

    private boolean isFirstOrder() {
        return this.tokenCount == 1;
    }

    private void validateInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("null 또는 빈 공백은 입력할 수 없습니다.");
        }
    }

    private void handleOperator(String token) {
        if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
            changeOperator(token);
            return;
        }
        throw new IllegalArgumentException("유효하지 않은 사칙연산 기호입니다. 다시 입력 해 주세요.");
    }

    private void changeOperator(String token) {
        this.lastOperator = token;
    }

    private int calculateByOperator(String token) {
        try {
            int number = Integer.parseInt(token);

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
        } catch (NumberFormatException e) {
            throw new NumberFormatException("유효한 숫자가 아닙니다. " + e.getMessage());
        }
        return 0;
    }

    private int divideTwoNumber(int result, int number) {
        if (number == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return result / number;
    }

    private int handleFirstInteger(String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("유효하지 않은 첫 번째 정수: " + token);
        }
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
