import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (a, b) -> {
        return a + b;
    }),
    MINUS("-", (a, b) -> {
        return a - b;
    }),
    DIVE("/", (a, b) -> {
        return a / b;
    }),
    MULTIPLY("*", (a, b) -> {
        return a * b;
    });

    private String value;
    private BiFunction<Integer, Integer, Integer> calc;

    Operator(String value, BiFunction<Integer, Integer, Integer> calc) {
        this.value = value;
        this.calc = calc;
    }

    public static Operator findOperator(String input) {
        Optional<Operator> op = Arrays.stream(values())
                .filter(operator -> isEqual(operator, input))
                .findAny();

        if (op.isEmpty()) {
            throw new IllegalArgumentException("올바르지 않은 수식입니다.");
        }

        return op.get();
    }

    private static boolean isEqual(Operator op, String input) {
        return op.value.equals(input);
    }

    public int calculate(int op1, int op2) {
        return calc.apply(op1, op2);
    }
}
