package calculator;

import java.util.HashMap;
import java.util.Map;

public class StringCalculator {

    private final Map<String, BasicOperator> operators;

    public StringCalculator() {
        operators = new HashMap<>();
        operators.put("+", new Plus());
        operators.put("-", new Minus());
        operators.put("*", new Multiply());
        operators.put("/", new Divide());
    }

    public static String[] getSplit(String text) {
        String[] split = text.split(" ");
        return split;
    }

    public static boolean isBlank(String text) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값이 빈문자열 또는 공백입니다.");
        }
        return true;
    }

    public int calculate(String input) {
        isBlank(input);
        String[] split = getSplit(input);
        int result = Integer.parseInt(split[0]);
        for (int i = 1; i < split.length; i += 2) {
            int nextNumber = Integer.parseInt(split[i + 1]);
            result = operate(result, nextNumber, split[i]);
        }
        return result;
    }

    public int operate(int number1, int number2, String operator) {
        BasicOperator basicOperator = operators.get(operator);
        if (basicOperator == null) {
            throw new IllegalArgumentException("올바르지 않은 연산자입니다: " + operator);
        }
        return basicOperator.calculate(number1, number2);
    }
}
