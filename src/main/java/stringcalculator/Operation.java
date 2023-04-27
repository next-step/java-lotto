package stringcalculator;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.DoubleBinaryOperator;

public enum Operation {
    PLUS("+",(a,b) -> a+b),
    MINUS("-",(a,b) -> a-b),
    MULTIPLY("*",(a,b) -> a*b),
    DIVIDE("/",(a,b) -> a/b);

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
                .orElse(null);
    }

    public Double calculate(double number1, double number2) {
        return this.biFunction.apply(number1,number2);
    }
}
