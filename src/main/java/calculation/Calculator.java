package calculation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    private static final List<String> ARITHMETIC_SYMBOLS = Arrays.asList("+", "-", "*", "/");

    public static int addition(int number1, int number2) {
        return number1 + number2;
    }

    public static int subtraction(int number1, int number2) {
        return number1 - number2;
    }

    public static int multiplication(int number1, int number2) {
        return number1 * number2;
    }

    public static int division(int number1, int number2) {
        return number1 / number2;
    }

    public static int calculate(String symbol, int number1, int number2) {
        if ("+".equals(symbol)) {
            return addition(number1, number2);
        } else if ("-".equals(symbol)) {
            return subtraction(number1, number2);
        } else if ("*".equals(symbol)) {
            return multiplication(number1, number2);
        } else if ("/".equals(symbol)) {
            return division(number1, number2);
        }
        return 0;
    }

    public static int calculateExpression(String expression) {
        List<String> expressionElements = List.of(expression.split(" "));

        final int MAX_INPUT_NUMBERS = 2;
        List<Integer> numbers = new ArrayList<>();
        String symbol = "";

        for (String e : expressionElements) {
            if (isNumberic(e)) {
                numbers.add(Integer.valueOf(e));
            }
            if (!isNumberic(e) && isArithmeticSymbol(e)) {
                symbol = e;
            }
            if (numbers.size() == MAX_INPUT_NUMBERS) {
                numbers.add(Calculator.calculate(symbol, numbers.remove(0), numbers.remove(0)));
            }
        }

        return numbers.get(0);
    }

    private static boolean isNumberic(String str) {
        return str.matches("[+-]?\\d+");
    }

    private static boolean isArithmeticSymbol(String symbol) {
        if (!ARITHMETIC_SYMBOLS.contains(symbol)) {
            throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
        }
        return true;
    }
}