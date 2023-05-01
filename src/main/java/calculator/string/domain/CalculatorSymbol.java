package calculator.string.domain;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.BiFunction;

public enum CalculatorSymbol {
    ADD("+", Integer::sum),
    SUB("-", (a, b) -> (a - b)),
    MULTIPLY("*", (a, b) -> (a * b)),
    DIVIDE("/", (a, b) -> {
        if(a % b > 0) {
            throw new IllegalArgumentException("나눗셈의 결과값이 정수가 아닙니다.");
        }
        return a / b;
    });

    private final String symbol;
    private final BiFunction<Integer, Integer, Integer> calculation;

    public static CalculatorSymbol getSymbol(String value) {
        return Arrays.stream(CalculatorSymbol.values())
                .filter(calculatorSymbol -> Objects.equals(calculatorSymbol.symbol, value))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public int calculate(int a, int b) {
        return this.calculation.apply(a, b);
    }

    CalculatorSymbol(String symbol, BiFunction<Integer, Integer, Integer> calculation) {
        this.symbol = symbol;
        this.calculation = calculation;
    }
}
