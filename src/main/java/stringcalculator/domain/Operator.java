package stringcalculator.domain;

import java.util.Arrays;

public enum Operator {
    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/");

    private final String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    public static Operator of(String operator) {
        return Arrays.stream(values())
                .filter(e -> e.operator.equals(operator))
                .findAny()
                .orElseThrow(()
                        -> new IllegalArgumentException("사칙연산의 기호가 아닙니다."));
    }

    public int operate(int o1, int o2) {
        if (operator.equals("+")) {
            return o1 + o2;
        }

        if (operator.equals("-")) {
            return o1 - o2;
        }

        if (operator.equals("*")) {
            return o1 * o2;
        }

        validateDividing(o1, o2);
        return o1 / o2;
    }

    private void validateDividing(int o1, int o2) {
        if (o1 % o2 != 0) {
            throw new IllegalArgumentException("약수만 사용할 수 있습니다.");
        }
    }
}
