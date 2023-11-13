package domain;

import java.util.List;

public class StringCalculator {
    private List<String> input;
    private BasicOperator calculator;

    public StringCalculator(List<String> input) {
        this.input = input;
//        calculator =
    }

    public int calculator() {
        try {
            int result = Integer.parseInt(input.get(0));
            for (int i = 0; i < input.size() - 2; i += 2) {
                result = stringCalulator(result, String.valueOf(input.get(i + 1)), Integer.parseInt(input.get(i + 2)));
            }
            return result;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }
    }

    private int stringCalulator(int result, String operator, int num) {
        calculator = new BasicOperator();
        checkOperator(operator);
        if ("+".equals(operator)) {
            return calculator.add(result, num);
        }
        if ("-".equals(operator)) {
            return calculator.substract(result, num);
        }
        if ("*".equals(operator)) {
            return calculator.multiply(result, num);
        }
        if ("/".equals(operator)) {
            return calculator.divide(result, num);
        }
        return result;
    }

    private static void checkOperator(String operator) {
        if (!"+".equals(operator) && !"-".equals(operator) && !"*".equals(operator) && !"/".equals(operator))
            throw new IllegalArgumentException("사칙연산 기호는 +, -, *, / 만 가능합니다.");
    }
}
