package string_calculator;

import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", plus()), MINUS("-", minus()), MULTIPLY("*", multiply()), DIVIDE("/", divide()), MODULO("%", modulo());

    private String value;
    public BiFunction<Integer, Integer, Integer> compute;

    private static BiFunction<Integer, Integer, Integer> plus() {
        return (acc, operand) -> acc + operand;
    }

    private static BiFunction<Integer, Integer, Integer> minus() {
        return (acc, operand) -> acc - operand;
    }

    private static BiFunction<Integer, Integer, Integer> multiply() {
        return (acc, operand) -> acc * operand;
    }

    private static BiFunction<Integer, Integer, Integer> divide() {
        return (acc, operand) -> {
            divideByZeroChecker(operand);
            return divideToInteger(acc, operand);
        };
    }

    private static BiFunction<Integer, Integer, Integer> modulo() {
        return (acc, operand) -> acc % operand;
    }

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
