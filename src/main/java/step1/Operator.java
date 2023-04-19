package step1;

import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", Integer::sum),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> num1 / num2);

    private final String symbol;
    private final BiFunction<Integer, Integer, Integer> operator;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    public String getSymbol() {
        return symbol;
    }

    public int calculate(int num1, int num2) {
        return operator.apply(num1, num2);
    }

}
