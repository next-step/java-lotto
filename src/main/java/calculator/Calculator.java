package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Calculator {
    PLUS("+", (prevNumber, number) -> prevNumber + number),
    MINUS("-", (prevNumber, number) -> prevNumber - number),
    MULTIPLY("*", (prevNumber, number) -> prevNumber * number),
    DIVIDE("/", (prevNumber, number) -> prevNumber / number);

    private String symbol;
    private BiFunction<Integer, Integer, Integer> expression;

    Calculator(String symbol, BiFunction<Integer, Integer, Integer> expression) {
        this.symbol = symbol;
        this.expression = expression;
    }

    public int calculate(int prevNumber, int number) {
        return expression.apply(prevNumber, number);
    }

    public static Calculator findSymbol(String symbol) {
        return Arrays.stream(values())
                .filter(target -> target.getSymbol().equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("사칙연산 기호가 아닙니다!"));
    }

    public String getSymbol() {
        return symbol;
    }

}
