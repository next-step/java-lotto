package stringcalculator;

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

    public Double calculate(Double number1, Double number2) {
        return this.biFunction.apply(number1,number2);
    }
}
