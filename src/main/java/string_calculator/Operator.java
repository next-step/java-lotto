package string_calculator;

import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (acc, operand) -> acc + operand),
    MINUS("-", (acc, operand) -> acc - operand),
    MULTIPLY("*", (acc, operand) -> acc * operand),
    DIVIDE("/", (acc, operand) -> {
        divideByZeroChecker(operand);
        return divideToInteger(acc, operand);
    }),
    MODULO("%", (acc, operand) -> acc % operand);

    private String value;
    public BiFunction<Integer, Integer, Integer> compute;

    Operator(String value, BiFunction<Integer, Integer, Integer> compute) {
        this.value = value;
        this.compute = compute;
    }

    private static int ZERO = 0;



    public static Operator create(String value) {
        if (PLUS.value.equals(value)) {
            return PLUS;
        }
        if (MINUS.value.equals(value)) {
            return MINUS;
        }
        if (MULTIPLY.value.equals(value)) {
            return MULTIPLY;
        }
        if (DIVIDE.value.equals(value)) {
            return DIVIDE;
        }
        if (MODULO.value.equals(value)) {
            return MODULO;
        }
        throw new IllegalArgumentException("only [+, -, *, /, %] are allowed. but: " + value);
    }

    private static Integer divideToInteger(Integer acc, Integer operand) {
        Boolean isDividable = acc % operand == 0;
        if (isDividable) {
            return acc / operand;
        }
        throw new IllegalArgumentException("Can't divide.");
    }

    private static void divideByZeroChecker(Integer operand) {
        if (operand == ZERO) {
            throw new ArithmeticException("Can't divide by Zero.");
        }
    }

}
