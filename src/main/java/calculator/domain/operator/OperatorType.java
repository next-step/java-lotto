package calculator.domain.operator;

import java.util.Arrays;

public enum OperatorType {
    ADDITION("+", Integer::sum),
    SUBTRACTION("-", (num1, num2) -> num1 - num2),
    MULTIPLICATION("*", (num1, num2) -> num1 * num2),
    DIVISION("/", (num1, num2) -> {
        validateDivision(num1, num2);
        return num1 / num2;
    }),
    ;

    private final String field;
    private final Operator operator;

    OperatorType(String field, Operator operator) {
        this.field = field;
        this.operator = operator;
    }

    public static OperatorType of(String field) {
        return Arrays.stream(values())
                .filter(v -> field.equals(v.field))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("지원하는 연산기호가 아닙니다."));
    }

    public int calculate(int num1, int num2) {
        return operator.apply(num1, num2);
    }

    private static void validateDivision(int num1, int num2) {
        if (num1 % num2 != 0) {
            throw new IllegalArgumentException("나눗셈의 결과가 정수가 아닙니다.");
        }
    }
}
