package stringcalculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operation {
    PLUS("+", (number1, number2) -> number1 + number2),
    MINUS("-", (number1, number2) -> number1 - number2),
    MULTIPLY("*", (number1, number2) -> number1 * number2),
    DIVIDE("/", Operation::divide);

    private static Double divide(Double number1, Double number2) {
        validateDivide(number2);
        return number1 / number2;
    }

    private static void validateDivide(Double divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("나누는 수는 0일 수 없습니다.");
        }
    }

    private final String symbol;
    private final BiFunction<Double, Double, Double> biFunction;

    Operation(String symbol, BiFunction<Double, Double, Double> biFunction) {
        this.symbol = symbol;
        this.biFunction = biFunction;
    }

    public static Operation find(String symbol) {
        return Arrays.stream(Operation.values())
                .filter(operation -> symbol.equals(operation.symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(symbol + "에 해당하는 사칙연산이 현재 없습니다."));
    }

    public Double calculate(double number1, double number2) {
        return this.biFunction.apply(number1, number2);
    }
}
