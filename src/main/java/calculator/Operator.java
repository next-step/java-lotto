package calculator;

import calculator.exception.DivisionCannotBeZeroException;
import calculator.exception.InvalidOperatorException;

import java.util.HashMap;
import java.util.Map;
import java.util.function.IntBinaryOperator;

public class Operator {
    private static final Map<String, IntBinaryOperator> operaterMap = new HashMap<>();
    public static final String DELIMITER = " ";

    public static final String PLUS = "+";
    public static final String MINUS = "-";
    public static final String MULTIPLY = "*";
    public static final String DEVIDE = "/";

    private static Operator operator;

    static {
        operaterMap.put(PLUS, (a, b) -> a + b);
        operaterMap.put(MINUS, (a, b) -> a - b);
        operaterMap.put(MULTIPLY, (a, b) -> a * b);
        operaterMap.put(DEVIDE, (a, b) -> {
            validDivision(b);
            return a / b;
        });
    }

    private Operator() {

    }

    public static Operator getOperator() {
        if (operator == null) {
            operator = new Operator();
        }
        return operator;
    }

    private static void validDivision(int b) {
        if (b == 0)
            throw new DivisionCannotBeZeroException(b);
    }

    public static IntBinaryOperator selection(String s) {
        if (!operaterMap.containsKey(s)) {
            throw new InvalidOperatorException(s);
        }
        return operaterMap.get(s);
    }

    public int calculate(String expression) {
        String[] splited = splitString(expression);

        int result = Integer.parseInt(splited[0]);
        for (int i = 1; i < splited.length - 1; i += 2) {
            int operand = Integer.parseInt(splited[i + 1]);
            IntBinaryOperator operator = selection(splited[i]);
            result = operator.applyAsInt(result, operand);
        }

        return result;
    }

    public String[] splitString(String input) {
        return input.split(DELIMITER);
    }

}
