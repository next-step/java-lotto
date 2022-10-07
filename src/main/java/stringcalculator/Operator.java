package stringcalculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    MULTIPLY("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> {
        try {
            return x / y;
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
    }),
    ;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> calc) {
        this.symbol = symbol;
        this.calc = calc;
    }

    private final String symbol;
    private final BiFunction<Integer, Integer, Integer> calc;

    public static Operator findOperator(String operator) {
        return Arrays.asList(Operator.values())
                .stream()
                .filter(oper -> oper.symbol.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("사용할수 없는 연산자입니다."));
    }

    public int calc(int num1, int num2) {
        return this.calc.apply(num1, num2);
    }
}
