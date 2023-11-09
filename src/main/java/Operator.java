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

    public static Operator valueByOperation(String operation) {
        return Arrays.stream(values()).filter(value -> value.operation.equals(operation))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static List<Operator> byStringOperators(List<String> stringOperators) {
        List<Operator> operators = new ArrayList<>();

        for (String stringOperator: stringOperators) {
            operators.add(Operator.valueByOperation(stringOperator));
        }

        return operators;
    }

    public int operate(int num1, int num2) {
        return expression.apply(num1, num2);
    }
}
