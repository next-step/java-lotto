import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", Integer::sum),
    MINUS("-", (num1, num2) -> num1 - num2),
    DIVIDE("/", (num1, num2) -> num1 / num2),
    MULTIPLE("*", (num1, num2) -> num1 * num2);

    private final String operation;
    private final BiFunction<Integer, Integer, Integer> expression;

    Operator(String operation, BiFunction<Integer, Integer, Integer> expression) {
        this.operation = operation;
        this.expression = expression;
    }

    static Operator valueByOperation(String operation) {
        return Arrays.stream(values()).filter(value -> value.operation.equals(operation))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    static List<Operator> byString(String value) {
        String[] split = value.split(" ");
        List<Operator> operators = new ArrayList<>();

        for (int idx = 1; idx < split.length; idx += 2) {
            operators.add(Operator.valueByOperation(split[idx]));
        }

        return operators;
    }

    public int operate(int num1, int num2) {
        return expression.apply(num1, num2);
    }
}
