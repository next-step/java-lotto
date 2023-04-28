package calculator.Enums;

import java.util.function.BiFunction;

import calculator.Model.Number;

public enum Operator {
    PLUS("+", (a, b) -> a.plus(b)),
    MINUS("-", (a, b) -> a.minus(b)),
    MULTIPLE("*", (a, b) -> a.multiple(b)),
    DIVIDE("/", (a, b) -> a.divide(b));

    private String symbol;
    private BiFunction<Number, Number, Number> function;

    Operator(String symbol, BiFunction<Number, Number, Number> function) {
        this.symbol = symbol;
        this.function = function;
    }

    public static Operator of(String element) {
        for (Operator operator : values()) {
            if (operator.symbol.equals(element)) {
                return operator;
            }
        }

        throw new IllegalArgumentException("연산자가 아닙니다.");
    }

    public Number execute(Number numBefore, Number numAfter) {
        return this.function.apply(numBefore, numAfter);
    }
}
