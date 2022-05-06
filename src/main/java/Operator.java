import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public enum Operator {
    PLUS("+", (a, b) -> (a + b)),
    MINUS("-", (a, b) -> (a - b)),
    MULTIPLY("*", (a, b) -> (a * b)),
    DIVISION("/", (a, b) -> (a / b));

    private final String op;
    private final BiFunction<Integer, Integer, Integer> calculate;

    Operator(final String op, final BiFunction<Integer, Integer, Integer> calculate) {
        this.op = op;
        this.calculate = calculate;
    }

    public static Operator getEnum(String op) {
        BiPredicate<Operator, String> filter = (x, y) -> x.op.equals(y);

        return Arrays.stream(values())
                     .filter(value -> filter.test(value, op))
                     .findAny()
                     .orElseThrow(() -> new IllegalArgumentException("일치하는 값이 없습니다."));
    }

    public Integer calculate(int a, int b) {
        return this.calculate.apply(a, b);
    }
}
