package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class CalculatorFactory {
    public static Calculator createCalculator(String expression) {
        if (isNullOrEmpty(expression)) {
            throw new IllegalArgumentException("수식이 비어있습니다.");
        }

        final List<Number> numbers = new ArrayList<>();
        final List<Operator> operators = new ArrayList<>();

        for (String token : expression.split(" ")) {
            parseToken(token, numbers, operators);
        }
       return new Calculator(numbers, operators);
    }

    private static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private static void parseToken(String token, List<Number> numbers, List<Operator> operators) {
        if (isInteger(token)) {
            numbers.add(new Number(Integer.parseInt(token)));
        } else {
            operators.add(new Operator(token));
        }
    }

    private static boolean isInteger(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
