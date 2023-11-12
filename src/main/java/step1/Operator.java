package step1;

import java.util.function.IntBinaryOperator;
import java.util.stream.Stream;

public enum Operator implements IntBinaryOperator {

    PLUS("+", Integer::sum),
    MINUS("-", (l, r) -> Integer.sum(l, -r)),
    MULTIPLICATION("*", (l, r) -> l * r),
    DIVISION("/", (l, r) -> l / r),
    ;

    private final String symbol;
    private final IntBinaryOperator intBinaryOperator;

    Operator(String symbol, IntBinaryOperator intBinaryOperator) {
        this.symbol = symbol;
        this.intBinaryOperator = intBinaryOperator;
    }

    @Override
    public int applyAsInt(int left, int right) {
        return intBinaryOperator.applyAsInt(left, right);
    }

    public static Operator getOperator(String input) {
        return Stream.of(Operator.values())
                     .filter(opt -> opt.symbol.equals(input))
                     .findFirst()
                     .orElseThrow(() -> new IllegalArgumentException("부_적절한 연산_기호"));
    }
}
