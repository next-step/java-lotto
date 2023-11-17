package calculator;

import java.util.Arrays;

public enum Operator {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String symbol;
    Operator(String symbol) {
        this.symbol = symbol;
    }

    public String symbol() {
        return symbol;
    }

    public static Operator findSymbol(String character) {
        return Arrays.stream(Operator.values())
                .filter(operator ->  operator.symbol.equals(character)).findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public int calculate(int result, int operand) {
        switch (this) {
            case ADD:
                return plus(result, operand);
            case SUBTRACT:
                return minus(result, operand);
            case MULTIPLY:
                return multiply(result, operand);
            default:
                return divide(result, operand);
        }
    }

    public int plus(int result, int value) {
        return result + value;
    }

    public int minus(int result, int value) {
        return result - value;
    }

    public int multiply(int result, int value) {
        return result * value;
    }

    public int divide(int result, int value) {
        if (result % value != 0) {
            throw new IllegalArgumentException();
        }
        return result / value;
    }
}
