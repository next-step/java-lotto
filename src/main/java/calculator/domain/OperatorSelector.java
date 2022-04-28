package calculator.domain;

import java.util.Arrays;

public enum OperatorSelector {
    PLUS("+", Integer::sum),
    MINUS("-", (number1, number2) -> number1 - number2),
    MULTIPLY("*", (number1, number2) -> number1 * number2),
    DIVIDE("/", (number1, number2) -> {
        if (number2 == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return number1 / number2;
    });

    private final String symbol;
    private final Operator operator;

    OperatorSelector(String symbol, Operator operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    public static Operator findOperator(String symbol) {
        return Arrays.stream(OperatorSelector.values())
                .filter(operatorType -> operatorType.symbol.equals(symbol))
                .map(operatorType -> operatorType.operator)
                .findAny()
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("존재하지 않는 연산자입니다.");
                });
    }
}
