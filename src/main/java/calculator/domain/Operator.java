package calculator.domain;

import java.util.Arrays;
import java.util.Map;

import static java.util.stream.Collectors.toUnmodifiableMap;

public enum Operator {
    ADD("+"), SUB("-"), MUL("*"), DIV("/");

    private static final Map<String, Operator> VALUE_MAP
            = Arrays.stream(Operator.values())
            .collect(toUnmodifiableMap(Operator::getValue, e -> e));

    private final String value;

    Operator(String value) {
        this.value = value;
    }

    public static Operator findOperator(String operator) {
        if (!VALUE_MAP.containsKey(operator)) {
            throw new IllegalArgumentException("잘못된 연산자를 사용하였습니다.");
        }
        return VALUE_MAP.get(operator);
    }

    public Operation toOperation() {
        return Operation.findType(this);
    }

    public String getValue() {
        return value;
    }

}