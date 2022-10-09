package stringcalculator;

import java.util.List;
import java.util.NoSuchElementException;

public enum ArithmeticOperator {
    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> {
        validateDivideArguments(a, b);
        return a / b;
    });

    private static void validateDivideArguments(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("0 으로 나눌 수 없습니다.");
        }
        if (a % b != 0) {
            throw new IllegalArgumentException("정수로 나누어 떨어지지 않습니다.");
        }
    }

    private static final List<ArithmeticOperator> ALL_VALUES = List.of(values());

    private final String symbol;
    private final CalculationFunction expression;

    ArithmeticOperator(String symbol, CalculationFunction expression) {
        this.symbol = symbol;
        this.expression = expression;
    }

    public static ArithmeticOperator from(String symbol) {
        return ALL_VALUES.stream()
                .filter(operator -> operator.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("사칙연산 기호를 찾을 수 없습니다."));
    }

    public int calculate(int a, int b) {
        return expression.calcuate(a, b);
    }

}
