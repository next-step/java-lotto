package stringcalculator.model;

import java.util.function.BiFunction;

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
        if (SUM.label.equals(label)) {
            return SUM;
        }
        if (SUBTRACT.label.equals(label)) {
            return SUBTRACT;
        }
        if (MULTIPLY.label.equals(label)) {
            return MULTIPLY;
        }
        if (DIVIDE.label.equals(label)) {
            return DIVIDE;
        }
        throw new IllegalArgumentException(NOT_ALLOWED_OPERATOR_ANOTHER_STRINGS);
    }

    public Operand calculate(Operand left, Operand right) {
        return new Operand(calculate.apply(left.value(), right.value()));
    }
}
