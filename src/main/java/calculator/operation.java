package calculator;

import java.util.function.BiFunction;

import static calculator.Calculation.*;

public enum operation {
    PLUS("+",(first, second)-> plus(first, second)),
    SUBTRACT("-",(first, second)-> subtract(first, second)),
    MULTIPLY("*",(first, second)-> multiply(first, second)),
    DIVIDE("/",(first, second)-> subtract(first, second));

    private String sign;
    private final BiFunction<Integer, Integer, Integer> biFunction;

    operation(String sign, BiFunction<Integer, Integer, Integer> biFunction) {
        this.sign = sign;
        this.biFunction = biFunction;
    }

    public int calculate(int first, int second){
        return this.biFunction.apply(first, second);
    }
}
