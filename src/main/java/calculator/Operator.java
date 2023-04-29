package calculator;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Operator {
    ADD("+", Integer::sum),
    SUBTRACT("-", (a, b) -> (a - b)),
    MULTIPLY("*", (a, b) -> (a * b)),
    DIVIDE("/", (a, b) -> (a / b));

    private final String type;
    private final BinaryOperator<Integer> formula;

    Operator(String type, BinaryOperator<Integer> formula) {
        this.type = type;
        this.formula = formula;
    }

    public static int calculate(String type, int operand1, int operand2) {
        Operator operator = findOperator(type);
        return operator.calculate(operand1, operand2);
    }

    private static Operator findOperator(String operator) {
        return Arrays.stream(values())
                .filter(item -> item.type.equals(operator))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public int calculate(int a, int b) {
        return formula.apply(a, b);
    }

}
