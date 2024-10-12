package calculator;

import calculator.exception.DivisionCannotBeZeroException;
import calculator.exception.InvalidOperatorException;

import java.util.HashMap;
import java.util.Map;
import java.util.function.IntBinaryOperator;

public class Operator {
    private static final Map<String, IntBinaryOperator> operaterMap = new HashMap<>();

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

    private static void validDivision(int division) {
        if (division == 0)
            throw new DivisionCannotBeZeroException(division);
    }

    public IntBinaryOperator selection(String s) {
        if (!operaterMap.containsKey(s)) {
            throw new InvalidOperatorException(s);
        }
        return operaterMap.get(s);
    }

}
