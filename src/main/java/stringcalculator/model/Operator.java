package stringcalculator.model;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public enum Operator {
    SUM("+", (left, right) -> left + right),
    SUBTRACT("-", (left, right) -> left - right),
    MULTIPLY("*", (left, right) -> left * right),
    DIVIDE("/", (left, right) -> left / right);

    public static final String NOT_ALLOWED_OPERATOR_ANOTHER_STRINGS = "연산자는 특수문자 +,-,*,/ 이외에 다른 문자가 올 수 없습니다.";
    private final String label;
    private final BiFunction<Integer, Integer, Integer> calculate;

    Operator(String label, BiFunction<Integer, Integer, Integer> calculate) {
        this.label = label;
        this.calculate = calculate;
    }

    public static Operator convertToOperator(String label) {
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.label.equals(label))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_ALLOWED_OPERATOR_ANOTHER_STRINGS));
    }

    public Operand calculate(Operand left, Operand right) {
        return new Operand(calculate.apply(left.value(), right.value()));
    }
}
