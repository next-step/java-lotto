package stringcalculator;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum ArithmeticOperator {
    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> {
        if (a % b != 0) {
            throw new IllegalArgumentException("정수로 나누어 떨어지지 않습니다.");
        }
        return a / b;
    });

    private final String symbol;
    private final CalculationFunction expression;

    ArithmeticOperator(String symbol, CalculationFunction expression) {
        this.symbol = symbol;
        this.expression = expression;
    }

    public static ArithmeticOperator from(String symbol) {
        return Arrays.stream(values())
                .filter(operator -> operator.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("사칙연산 기호를 찾을 수 없습니다."));
    }

    public int calculate(int a, int b) {
        return expression.calcuate(a, b);
    }

}
