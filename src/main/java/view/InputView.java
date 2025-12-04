package view;

import calculator.Calculator;

public class InputView {
    public static void calculate(String input) {
        validateInput(input);
        String[] split = input.split(" ");

        int left = Integer.parseInt(split[0]);

        for (int i = 1; i < split.length; i++) {
            String operator = split[i];
            int right = Integer.parseInt(split[++i]);

            Calculator calculator = new Calculator(left, operator, right);
            left = calculator.getString(left, operator, right);

            System.out.println("현재까지 계산 결과: " + left);
        }
    }

    private static void validateInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력 값이 null이거나 빈 공백 문자일 수 없습니다.");
        }

        String[] split = input.split(" ");
        for (int i = 1; i < split.length; i += 2) {
            String operator = split[i];
            if (!operator.equals("+") && !operator.equals("-") && !operator.equals("*") && !operator.equals("/")) {
                throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
            }
        }
    }
}
