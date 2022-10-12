import java.util.function.BiFunction;

public enum Operator {

    ADD("+", Operator::sum),
    SUBTRACT("-", Operator::subtract),
    MULTIPLY("*", Operator::multiply),
    DIVIDE("/", Operator::divide);

    private final String operation;
    private final BiFunction<Integer, Integer, Integer> function;

    Operator(String operation, BiFunction<Integer, Integer, Integer> function) {
        this.operation = operation;
        this.function = function;
    }

    public static int sum(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("0을 나눌 수 없습니다.");
        }
        return a / b;
    }
}
