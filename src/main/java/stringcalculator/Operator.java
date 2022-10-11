package stringcalculator;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public enum Operator {
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    MULTIPLY("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> {
        if (y == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return x / y;
    }),
    ;

    Operator(String symbol, BinaryOperator<Integer> calc) {
        this.symbol = symbol;
        this.calc = calc;
    }

    private final String symbol;
    private final BinaryOperator<Integer> calc;

    public static Operator findOperator(String operator) {
        return Arrays.stream(Operator.values())
                .filter(oper -> oper.symbol.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("사용할수 없는 연산자입니다."));
    }

    public int calc(int num1, int num2) {
        return this.calc.apply(num1, num2);
    }
}
