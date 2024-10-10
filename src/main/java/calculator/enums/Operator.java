package calculator.enums;

import calculator.domain.OperatorMethod;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Operator {
    PLUS("+", Integer::sum),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> {
        if (num2 == 0) {
            throw new IllegalStateException("분모가 0이 될 수 없습니다.");
        }
        return num1 / num2;
    });

    private final String operator;
    private final OperatorMethod operatorClass;

    Operator(String operator, OperatorMethod operatorClass) {
        this.operator = operator;
        this.operatorClass = operatorClass;
    }

    public String getOperator() {
        return operator;
    }

    public static List<String> getOperators() {
        return Arrays.stream(Operator.values())
                .map(Operator::getOperator)
                .collect(Collectors.toUnmodifiableList());
    }

    public static Operator from(String operator) {
        return Arrays.stream(Operator.values())
                .filter(s -> operator.equals(s.operator))
                .findAny()
                .orElseThrow(() -> new IllegalStateException("해당하는 operator가 존재하지 않습니다."));
    }

    public int operate(int num1, int num2) {
        return this.operatorClass.operate(num1, num2);
    }
}
