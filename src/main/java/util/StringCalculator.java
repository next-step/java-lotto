package util;

public class StringCalculator {

    public int calculate(String input) {
        validateInput(input);
        String[] tokens = input.split(" ");

        int result = Integer.parseInt(tokens[0]);

        for (int i = 1; i < tokens.length; i += 2) {
            String operator = tokens[i];
            int nextNumber = Integer.parseInt(tokens[i+1]);
            result = operate(operator, result, nextNumber);
        }
        return result;
    }

    private void validateInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("input이 null이거나 빈 문자열입니다.");
        }
    }

    private int operate(String operator, int num1, int num2) {
        if (operator.equals("+")) return num1 + num2;
        if (operator.equals("-")) return num1 - num2;
        if (operator.equals("*")) return num1 * num2;
        if (operator.equals("/")) {
            if (num2 == 0) throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
            if (num1 % num2 != 0) throw new IllegalArgumentException("나눔 값이 정수가 아닙니다.");
            return num1 / num2;
        }
        throw new IllegalArgumentException("올바른 사칙연산 부호가 아닙니다");
    }
}
