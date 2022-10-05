package stringcalculator;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum ArithmeticOperator {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String symbol;

    ArithmeticOperator(String symbol) {
        this.symbol = symbol;
    }

    public static ArithmeticOperator from(String symbol) {
        return Arrays.stream(values())
                .filter(operator -> operator.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("사칙연산 기호를 찾을 수 없습니다."));
    }

}
