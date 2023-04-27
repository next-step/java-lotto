package stringcalculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operation {
    PLUS("+",(a,b) -> a+b),
    MINUS("-",(a,b) -> a-b),
    MULTIPLY("*",(a,b) -> a*b),
    DIVIDE("/", Operation::devide);

    private static Double devide(Double number1, Double number2) {
        validateDivide(number2);
        return number1/number2;
    }

    private static void validateDivide(Double number2) {
        if(number2 == 0){
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
                .orElse(null);
    }

    public Double calculate(double number1, double number2) {
        return this.biFunction.apply(number1,number2);
    }
}
